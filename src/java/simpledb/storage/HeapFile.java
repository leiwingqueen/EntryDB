package simpledb.storage;

import simpledb.common.*;
import simpledb.transaction.LockManager;
import simpledb.transaction.TransactionAbortedException;
import simpledb.transaction.TransactionId;

import java.io.*;
import java.util.*;

/**
 * HeapFile is an implementation of a DbFile that stores a collection of tuples
 * in no particular order. Tuples are stored on pages, each of which is a fixed
 * size, and the file is simply a collection of those pages. HeapFile works
 * closely with HeapPage. The format of HeapPages is described in the HeapPage
 * constructor.
 *
 * @author Sam Madden
 * @see HeapPage#HeapPage
 */
public class HeapFile implements DbFile {
    private File file;
    private TupleDesc tupleDesc;

    /**
     * Constructs a heap file backed by the specified file.
     *
     * @param f the file that stores the on-disk backing store for this heap
     *          file.
     */
    public HeapFile(File f, TupleDesc td) {
        // some code goes here
        this.file = f;
        this.tupleDesc = td;
    }

    /**
     * Returns the File backing this HeapFile on disk.
     *
     * @return the File backing this HeapFile on disk.
     */
    public File getFile() {
        // some code goes here
        return file;
    }

    /**
     * Returns an ID uniquely identifying this HeapFile. Implementation note:
     * you will need to generate this tableid somewhere to ensure that each
     * HeapFile has a "unique id," and that you always return the same value for
     * a particular HeapFile. We suggest hashing the absolute file name of the
     * file underlying the heapfile, i.e. f.getAbsoluteFile().hashCode().
     *
     * @return an ID uniquely identifying this HeapFile.
     */
    public int getId() {
        // some code goes here
        String path = file.getAbsolutePath();
        return path.hashCode();
    }

    /**
     * Returns the TupleDesc of the table stored in this DbFile.
     *
     * @return TupleDesc of this DbFile.
     */
    public TupleDesc getTupleDesc() {
        // some code goes here
        return tupleDesc;
    }

    // see DbFile.java for javadocs
    public Page readPage(PageId pid) {
        // some code goes here
        RandomAccessFile accessFile = null;
        try {
            // file random access
            accessFile = new RandomAccessFile(this.file, "r");
            int pageSize = BufferPool.getPageSize();
            long offset = pid.getPageNumber() * pageSize;
            accessFile.seek(offset);
            byte[] buffer = new byte[pageSize];
            accessFile.read(buffer, 0, pageSize);
            return new HeapPage(new HeapPageId(pid.getTableId(), pid.getPageNumber()), buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // see DbFile.java for javadocs
    public void writePage(Page page) throws IOException {
        // some code goes here
        // not necessary for lab1
        RandomAccessFile accessFile = new RandomAccessFile(this.file, "rw");
        int pageSize = BufferPool.getPageSize();
        long offset = page.getId().getPageNumber() * pageSize;
        accessFile.seek(offset);
        accessFile.write(page.getPageData());
        accessFile.close();
    }

    /**
     * Returns the number of pages in this HeapFile.
     */
    public int numPages() {
        // some code goes here
        // how to get the page num?
        // cause we know the file size,we can get the page num.
        return (int) (file.length() / BufferPool.getPageSize());
    }

    // see DbFile.java for javadocs
    public List<Page> insertTuple(TransactionId tid, Tuple t)
            throws DbException, IOException, TransactionAbortedException {
        // some code goes here
        // not necessary for lab1

        // don't flush to the disk. only update heap page in memory
        // unsorted heap file.
        // we need to scan the hole file to find a page to insert the tuple
        // Debug.log("insert tuple...tid:%s", tid);
        BufferPool bufferPool = Database.getBufferPool();
        LockManager lockManager = bufferPool.getLockManager();
        // int i = 0;
        HeapPage selectPage = null;
        for (int i = 0; i < numPages(); i++) {
            PageId pageId = new HeapPageId(this.getId(), i);
            HeapPage page = (HeapPage) bufferPool.getPage(tid, pageId, Permissions.READ_WRITE);
            if (page.getNumUnusedSlots() > 0) {
                // find the page insert the tuple
                selectPage = page;
                break;
            }
            // no space insert. release the lock immediately
            lockManager.release(tid, pageId);
        }
        if (selectPage == null) {
            // need to create a new page
            // add an empty page the file
            byte[] emptyPageData = HeapPage.createEmptyPageData();
            HeapPageId pageId = new HeapPageId(this.getId(), numPages());
            HeapPage emptyPage = new HeapPage(pageId, emptyPageData);
            writePage(emptyPage);
            // load page to the buffer pool
            selectPage = (HeapPage) bufferPool.getPage(tid, pageId, Permissions.READ_WRITE);
        }
        // update buffer pool
        selectPage.insertTuple(t);
        Debug.log("insert tuple[success]...pageId:%s,tid:%s", selectPage.getId(), tid);
        return Arrays.asList(selectPage);
    }

    // see DbFile.java for javadocs
    public List<Page> deleteTuple(TransactionId tid, Tuple t) throws DbException,
            TransactionAbortedException {
        // some code goes here
        BufferPool bufferPool = Database.getBufferPool();
        PageId pageId = t.getRecordId().getPageId();
        HeapPage page = (HeapPage) bufferPool.getPage(tid, pageId, Permissions.READ_WRITE);
        page.deleteTuple(t);
        return Arrays.asList(page);
        // not necessary for lab1
    }

    // see DbFile.java for javadocs
    public DbFileIterator iterator(TransactionId tid) {
        // some code goes here
        return new HeapFileIterator(tid, this);
    }

    @Override
    public DbFileIterator reverseIterator(TransactionId tid) {
        throw new UnsupportedOperationException();
    }

    private enum HeapFileIterState {
        INIT,
        OPEN,
        CLOSE,
        ;
    }

    private static class HeapFileIterator implements DbFileIterator {
        // page and slot's offset
        private int tableId;
        private int pageNum;
        private int slotNum;
        private TransactionId txId;
        private int numPages;
        // private HeapFile heapFile;
        private HeapFileIterState state;
        private Tuple nextTuple;

        public HeapFileIterator(TransactionId txId, HeapFile heapFile) {
            this.tableId = heapFile.getId();
            this.pageNum = 0;
            this.slotNum = 0;
            this.txId = txId;
            this.numPages = heapFile.numPages();
            // this.heapFile = heapFile;
            state = HeapFileIterState.INIT;
        }

        @Override
        public void open() throws DbException, TransactionAbortedException {
            if (state == HeapFileIterState.CLOSE) {
                throw new DbException("iterator already close");
            }
            if (state == HeapFileIterState.OPEN) {
                throw new DbException("iterator already open");
            }
            state = HeapFileIterState.OPEN;
        }

        @Override
        public boolean hasNext() throws DbException, TransactionAbortedException {
            if (state != HeapFileIterState.OPEN) {
                return false;
            }
            if (nextTuple != null) {
                return true;
            }
            BufferPool bufferPool = Database.getBufferPool();
            while (pageNum < numPages) {
                // Question: is it better that we sequence scan the file?
                // we should call buffer pool when we get a page from disk.
                HeapPage curPage = (HeapPage) bufferPool.getPage(txId, new HeapPageId(tableId, pageNum), Permissions.READ_ONLY);
                while (slotNum < curPage.numSlots && !curPage.isSlotUsed(slotNum)) {
                    Debug.log("skip unused slot...pageNum:%d,slotNum:%d,totalPage:%d", pageNum, slotNum, numPages);
                    slotNum++;
                }
                if (slotNum < curPage.numSlots) {
                    Debug.log("fetch next tuple...pageNum:%d,slotNum:%d,totalPage:%d", pageNum, slotNum, numPages);
                    nextTuple = curPage.tuples[slotNum];
                    slotNum++;
                    // move to the next page
                    if (slotNum == curPage.numSlots) {
                        pageNum++;
                        slotNum = 0;
                    }
                    return true;
                }
                pageNum++;
                slotNum = 0;
            }
            Debug.log("no more tuple");
            return false;
        }

        @Override
        public Tuple next() throws DbException, TransactionAbortedException, NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("no more tuple or iterator is not open state");
            }
            Tuple tuple = nextTuple;
            nextTuple = null;
            return tuple;
        }

        @Override
        public void rewind() throws DbException, TransactionAbortedException {
            if (state != HeapFileIterState.OPEN) {
                throw new DbException("iterator is not open");
            }
            pageNum = 0;
            slotNum = 0;
        }

        @Override
        public void close() {
            state = HeapFileIterState.CLOSE;
        }
    }

}

