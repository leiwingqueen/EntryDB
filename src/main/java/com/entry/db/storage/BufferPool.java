package com.entry.db.storage;

import com.entry.db.common.*;
import com.entry.db.transaction.LockManager;
import com.entry.db.transaction.SimpleLockManager;
import com.entry.db.transaction.TransactionAbortedException;
import com.entry.db.transaction.TransactionId;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * BufferPool manages the reading and writing of pages into memory from
 * disk. Access methods call into it to retrieve pages, and it fetches
 * pages from the appropriate location.
 * <p>
 * The BufferPool is also responsible for locking;  when a transaction fetches
 * a page, BufferPool checks that the transaction has the appropriate
 * locks to read/write the page.
 *
 * @Threadsafe, all fields are final
 */
@Slf4j
public class BufferPool {
    /**
     * Bytes per page, including header.
     * 4k page size
     */
    private static final int DEFAULT_PAGE_SIZE = 4096;

    private static int pageSize = DEFAULT_PAGE_SIZE;

    private LockManager lockManager;

    /**
     * Default number of pages passed to the constructor. This is used by
     * other classes. BufferPool should use the numPages argument to the
     * constructor instead.
     */
    public static final int DEFAULT_PAGES = 50;

    // fix size pageTable
    private Page[] pageTable;
    // key-pageId,value-frameId
    private Map<PageId, Integer> pageId2FrameIdMap;
    // free list. O(1) to find the free space(used to call frame) to allocate the page
    private Deque<Integer> freeList;
    // page evict policy. we can simply use lru strategy.
    // link list+hash map
    private Map<PageId, LruNode> lruMap;
    private LruNode head;
    private LruNode tail;
    // private int pageSize = DEFAULT_PAGE_SIZE;
    private ReentrantReadWriteLock latch;

    /**
     * Creates a BufferPool that caches up to numPages pages.
     *
     * @param numPages maximum number of pages in this buffer pool.
     */
    public BufferPool(int numPages) {
        // some code goes here
        pageTable = new Page[numPages];
        // pageSize = DEFAULT_PAGE_SIZE;
        pageId2FrameIdMap = new ConcurrentHashMap<>();
        freeList = new LinkedList<>();
        for (int i = 0; i < numPages; i++) {
            freeList.add(i);
        }
        // lru data structure init
        lruMap = new HashMap<>();
        head = new LruNode(null);
        tail = new LruNode(null);
        head.next = tail;
        tail.pre = head;
        lockManager = new SimpleLockManager();
        latch = new ReentrantReadWriteLock();
    }

    public static int getPageSize() {
        return pageSize;
    }

    // THIS FUNCTION SHOULD ONLY BE USED FOR TESTING!!
    public static void setPageSize(int pageSize) {
        BufferPool.pageSize = pageSize;
    }

    // THIS FUNCTION SHOULD ONLY BE USED FOR TESTING!!
    public static void resetPageSize() {
        BufferPool.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * Retrieve the specified page with the associated permissions.
     * Will acquire a lock and may block if that lock is held by another
     * transaction.
     * <p>
     * The retrieved page should be looked up in the buffer pool.  If it
     * is present, it should be returned.  If it is not present, it should
     * be added to the buffer pool and returned.  If there is insufficient
     * space in the buffer pool, a page should be evicted and the new page
     * should be added in its place.
     *
     * @param tid  the ID of the transaction requesting the page
     * @param pid  the ID of the requested page
     * @param perm the requested permissions on the page
     */
    public Page getPage(TransactionId tid, PageId pid, Permissions perm)
            throws TransactionAbortedException, DbException {
        // some code goes here
        // acquire lock
        LockManager.LockMode lockMode = Permissions.READ_ONLY == perm ? LockManager.LockMode.S_LOCK : LockManager.LockMode.X_LOCK;
        lockManager.acquire(lockMode, tid, pid);
        Page page;
        latch.writeLock().lock();
        try {
            if (pageId2FrameIdMap.containsKey(pid)) {
                Integer frameId = pageId2FrameIdMap.get(pid);
                page = pageTable[frameId];
                // update lru map
                lruUpdate(pid);
            } else {
                if (freeList.size() == 0) {
                    // throw new DbException("not enough space to allocate page");
                    PageId evictPage = evictPage();
                    // log.info("for get page:{},evict page...page:{}", pid, evictPage);
                }
                Integer frameId = freeList.pollFirst();
                // load data from disk(random access disk)
                Catalog catalog = Database.getCatalog();
                DbFile dbFile = catalog.getDatabaseFile(pid.getTableId());
                page = dbFile.readPage(pid);
                pageTable[frameId] = page;
                pageId2FrameIdMap.put(pid, frameId);
                // update lru cache
                lruUpdate(pid);
            }
        } finally {
            latch.writeLock().unlock();
        }
        return page;
    }

    /**
     * Releases the lock on a page.
     * Calling this is very risky, and may result in wrong behavior. Think hard
     * about who needs to call this and why, and why they can run the risk of
     * calling it.
     *
     * @param tid the ID of the transaction requesting the unlock
     * @param pid the ID of the page to unlock
     */
    public void unsafeReleasePage(TransactionId tid, PageId pid) {
        // some code goes here
        // not necessary for lab1|lab2
        lockManager.release(tid, pid);
    }

    /**
     * Release all locks associated with a given transaction.
     *
     * @param tid the ID of the transaction requesting the unlock
     */
    public void transactionComplete(TransactionId tid) {
        // some code goes here
        // not necessary for lab1|lab2
        lockManager.releaseAll(tid);
    }

    /**
     * Return true if the specified transaction has a lock on the specified page
     */
    public boolean holdsLock(TransactionId tid, PageId p) {
        // some code goes here
        // not necessary for lab1|lab2
        return lockManager.holdsLock(tid, p) != null;
    }

    /**
     * Commit or abort a given transaction; release all locks associated to
     * the transaction.
     *
     * @param tid    the ID of the transaction requesting the unlock
     * @param commit a flag indicating whether we should commit or abort
     */
    public void transactionComplete(TransactionId tid, boolean commit) {
        log.debug("transactionComplete...tid:{},commit:{}", tid, commit);
        // some code goes here
        // not necessary for lab1|lab2
        // release all the log and flush all the dirty page into the disk
        latch.writeLock().lock();
        List<PageId> pageIds = new ArrayList<>();
        try {
            Iterator<PageId> pageIdIterator = lockManager.findAllLockPage(tid);
            while (pageIdIterator.hasNext()) {
                PageId pageId = pageIdIterator.next();
                if (commit) {
                    // force policy
                    try {
                        flushPage(pageId);
                        // use current page to replace the before image
                        Page page = getPage(tid, pageId, Permissions.READ_ONLY);
                        page.setBeforeImage();
                    } catch (IOException | DbException | TransactionAbortedException e) {
                        log.error(e.getMessage(), e);
                        // TODO: should we need to throw an exception?
                    }
                } else {
                    if (pageId2FrameIdMap.containsKey(pageId)) {
                        Integer frameId = pageId2FrameIdMap.get(pageId);
                        Page page = pageTable[frameId];
                        if (page.isDirty() != null) {
                            log.debug("page rollback...tid:{},pageId:{}", tid, page.getId());
                            pageTable[frameId] = page.getBeforeImage();
                        }
                    } else {
                        // no dirty page can swap out from memory. in this case, we should do nothing
                    }
                }
                pageIds.add(pageId);
            }
            for (PageId pageId : pageIds) {
                lockManager.release(tid, pageId);
            }
        } finally {
            latch.writeLock().unlock();
        }
    }

    /**
     * Add a tuple to the specified table on behalf of transaction tid.  Will
     * acquire a write lock on the page the tuple is added to and any other
     * pages that are updated (Lock acquisition is not needed for lab2).
     * May block if the lock(s) cannot be acquired.
     * <p>
     * Marks any pages that were dirtied by the operation as dirty by calling
     * their markDirty bit, and adds versions of any pages that have
     * been dirtied to the cache (replacing any existing versions of those pages) so
     * that future requests see up-to-date pages.
     *
     * @param tid     the transaction adding the tuple
     * @param tableId the table to add the tuple to
     * @param t       the tuple to add
     */
    public void insertTuple(TransactionId tid, int tableId, Tuple t)
            throws DbException, IOException, TransactionAbortedException {
        // some code goes here
        // not necessary for lab1
        log.debug("insert tuple...tid:{},tuple:{}", tid, t);
        Catalog catalog = Database.getCatalog();
        DbFile dbFile = catalog.getDatabaseFile(tableId);
        // update buffer pool data
        dbFile.insertTuple(tid, t);
        // markDirtyPages(tid, pages);
    }

    /**
     * Remove the specified tuple from the buffer pool.
     * Will acquire a write lock on the page the tuple is removed from and any
     * other pages that are updated. May block if the lock(s) cannot be acquired.
     * <p>
     * Marks any pages that were dirtied by the operation as dirty by calling
     * their markDirty bit, and adds versions of any pages that have
     * been dirtied to the cache (replacing any existing versions of those pages) so
     * that future requests see up-to-date pages.
     *
     * @param tid the transaction deleting the tuple.
     * @param t   the tuple to delete
     */
    public void deleteTuple(TransactionId tid, Tuple t)
            throws DbException, IOException, TransactionAbortedException {
        // some code goes here
        // not necessary for lab1
        log.debug("delete tuple...tid:{},tuple:{}", tid, t);
        Catalog catalog = Database.getCatalog();
        PageId pageId = t.getRecordId().getPageId();
        DbFile dbFile = catalog.getDatabaseFile(pageId.getTableId());
        List<Page> pages = dbFile.deleteTuple(tid, t);
        markDirtyPages(tid, pages);
    }

    // mark dirty
    private void markDirtyPages(TransactionId tid, List<Page> pages) throws DbException {
        for (Page page : pages) {
            page.markDirty(true, tid);
        }
    }

    /**
     * Flush all dirty pages to disk.
     * NB: Be careful using this routine -- it writes dirty data to disk so will
     * break simpledb if running in NO STEAL mode.
     */
    public void flushAllPages() throws IOException {
        // some code goes here
        // not necessary for lab1
        latch.writeLock().lock();
        for (PageId pageId : pageId2FrameIdMap.keySet()) {
            flushPage(pageId);
        }
        latch.writeLock().unlock();
    }

    /**
     * Remove the specific page id from the buffer pool.
     * Needed by the recovery manager to ensure that the
     * buffer pool doesn't keep a rolled back page in its
     * cache.
     * <p>
     * Also used by B+ tree files to ensure that deleted pages
     * are removed from the cache so they can be reused safely
     */
    public void removePage(PageId pid) {
        // some code goes here
        // not necessary for lab1
        latch.writeLock().lock();
        try {
            if (!pageId2FrameIdMap.containsKey(pid)) {
                return;
            }
            Integer frameId = pageId2FrameIdMap.get(pid);
            pageId2FrameIdMap.remove(pid);
            freeList.add(frameId);
            lruRemove(pid);
        } finally {
            latch.writeLock().unlock();
        }
    }

    /**
     * Flushes a certain page to disk
     *
     * @param pid an ID indicating the page to flush
     */
    private void flushPage(PageId pid) throws IOException {
        // some code goes here
        // not necessary for lab1
        latch.writeLock().lock();
        try {
            if (!pageId2FrameIdMap.containsKey(pid)) {
                return;
            }
            Integer frameId = pageId2FrameIdMap.get(pid);
            DbFile dbFile = Database.getCatalog().getDatabaseFile(pid.getTableId());
            Page page = pageTable[frameId];
            if (page.isDirty() != null) {
                log.debug("flush page to disk...pid:{}", pid);
                // append an update record to the log, with
                // a before-image and after-image.
                // redo log
                LogFile logFile = Database.getLogFile();
                logFile.logWrite(page.isDirty(), page.getBeforeImage(), page);
                logFile.force();
                page.markDirty(false, null);
                dbFile.writePage(page);
            }
        } finally {
            latch.writeLock().unlock();
        }
    }

    /**
     * Write all pages of the specified transaction to disk.
     */
    public void flushPages(TransactionId tid) throws IOException {
        // TODO: some code goes here
        // not necessary for lab1|lab2
    }

    public LockManager getLockManager() {
        return lockManager;
    }

    /**
     * Discards a page from the  pool.
     * Flushes the page to disk to ensure dirty pages are updated on disk.
     */
    private PageId evictPage() throws DbException {
        // some code goes here
        // not necessary for lab1
        if (head.next == tail) {
            throw new DbException("no page to evict");
        }
        LruNode node = head.next;
        Page pageEvict = null;
        while (node != tail) {
            Integer frameId = pageId2FrameIdMap.get(node.pageId);
            Page page = pageTable[frameId];
            if (page.isDirty() == null) {
                pageEvict = page;
                break;
            }
            node = node.next;
        }
        if (pageEvict == null) {
            // implement the steal strategy
            Integer frameId = pageId2FrameIdMap.get(head.next.pageId);
            pageEvict = pageTable[frameId];
            try {
                flushPage(pageEvict.getId());
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                throw new DbException("flush page error");
            }
            //throw new DbException("no page to evict");
        }
        // lru cache update
        lruRemove(pageEvict.getId());
        Integer frameId = pageId2FrameIdMap.get(pageEvict.getId());
        pageId2FrameIdMap.remove(pageEvict.getId());
        freeList.add(frameId);
        return pageEvict.getId();
    }

    private void lruRemove(PageId pageId) {
        if (!lruMap.containsKey(pageId)) {
            return;
        }
        LruNode lruNode = lruMap.get(pageId);
        LruNode pre = lruNode.pre;
        LruNode next = lruNode.next;
        pre.next = next;
        next.pre = pre;
        lruMap.remove(pageId);
    }

    private void lruUpdate(PageId pageId) {
        if (lruMap.containsKey(pageId)) {
            lruRemove(pageId);
        }
        // append new node to the end
        LruNode node = new LruNode(pageId);
        LruNode pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
        lruMap.put(pageId, node);
    }

    private static class LruNode {
        PageId pageId;
        LruNode pre;
        LruNode next;

        public LruNode(PageId pageId) {
            this.pageId = pageId;
        }
    }

}
