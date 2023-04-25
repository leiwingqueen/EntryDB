package com.entry.db.transaction;

import com.entry.db.storage.PageId;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// reference https://www.geeksforgeeks.org/implementation-of-locking-in-dbms/
// 《database system concepts》chapter figure 18.10
@Slf4j
public class SimpleLockManager implements LockManager {
    private Map<PageId, LockData> _lockTable;
    // use to find all the page which transaction holds
    private Map<TransactionId, Set<PageId>> _holdingTable;
    // deadlock detect
    // private TxWaitForGraph _txWaitForGraph;

    private ReentrantReadWriteLock _latch;

    // use for build wait for graph
    private Map<TransactionId, PageId> _waitForResource;
    private TxWaitForGraphV2 _txWaitForGraphV2;

    public SimpleLockManager() {
        _lockTable = new ConcurrentHashMap<>();
        _holdingTable = new ConcurrentHashMap<>();
        // _txWaitForGraph = new TxWaitForGraphImpl();
        _latch = new ReentrantReadWriteLock();
        _waitForResource = new ConcurrentHashMap<>();
        _txWaitForGraphV2 = new TxWaitForGraphV2();
    }

    @Override
    public void acquire(LockManager.LockMode lockMode, TransactionId txId, PageId pageId) throws TransactionAbortedException {
        _latch.writeLock().lock();
        LockNode lockNode;
        try {
            if (txId == null || tryAcquire(lockMode, txId, pageId)) {
                log.debug("get lock success...mode:{},txId:{},pageId:{},thread:{}", lockMode, txId, pageId, Thread.currentThread());
                return;
            }
            lockNode = new LockNode(lockMode, txId);
            LockData lockData = _lockTable.get(pageId);
            log.debug("get lock fail...mode:{},txId:{},pageId:{},thread:{},page lockData:{}", lockMode, txId, pageId, Thread.currentThread(), lockData);
            // try {
            // LockData lockData = _lockTable.get(pageId);
            // deadlock detect
            _waitForResource.put(txId, pageId);
            if (_txWaitForGraphV2.containsCircle(_lockTable, _waitForResource, txId)) {
                log.debug("dead lock found,throw TxAbortException");
                throw new TransactionAbortedException();
            }
            /*for (TransactionId holdTxId : lockData.holding.keySet()) {
                // case: tx1 and tx2 both hold the share lock, and tx1 is waiting for the exclusive lock
                if (holdTxId.equals(txId)) {
                    continue;
                }
                if (!_txWaitForGraph.addEdge(txId, holdTxId)) {
                    log.debug("dead lock found,throw TxAbortException");
                    for (TransactionId to : lockData.holding.keySet()) {
                        _txWaitForGraph.removeEdge(txId, to);
                    }
                    throw new TransactionAbortedException();
                }
            }*/
            // add to waiting list
            lockData.waiting.add(lockNode);
        } finally {
            _latch.writeLock().unlock();
        }
        // wait
        while (true) {
            synchronized (lockNode) {
                try {
                    lockNode.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // check if already get the lock
            if (holdsLock(txId, pageId) != null && holdsLock(txId, pageId).getVal() >= lockMode.getVal()) {
                return;
            }
        }
    }

    @Override
    public void release(TransactionId txId, PageId pageId) {
        log.debug("lock release...txId:{},pageId:{},thread:{}", txId, pageId, Thread.currentThread());
        _latch.writeLock().lock();
        try {
            LockData lockData = _lockTable.get(pageId);
            if (lockData == null) {
                return;
            }
            // case: txId is in waiting list, remove it from waiting list
            if (lockData.waiting.remove(txId)) {
                log.debug("remove from waiting list...txId:{},pageId:{}", txId, pageId);
                for (TransactionId holdTxId : lockData.holding.keySet()) {
                    if (holdTxId.equals(txId)) {
                        continue;
                    }
                    _txWaitForGraph.removeEdge(txId, holdTxId);
                }
            }
            // release lock that the txId holds
            if (holdsLock(txId, pageId) != null) {
                // update lock table
                lockData.holding.remove(txId);
                lockData.lockMode = null;
                _holdingTable.get(txId).remove(pageId);
                // update wait-for graph. iterate the waiting list,remove the edge that point to the txId
                for (LockNode lockNode : lockData.waiting) {
                    _txWaitForGraph.removeEdge(lockNode.txId, txId);
                }
                // case: txId is in waiting list
                if (lockData.waiting.remove(txId)) {
                    for (TransactionId holdTxId : lockData.holding.keySet()) {
                        if (holdTxId.equals(txId)) {
                            continue;
                        }
                        _txWaitForGraph.removeEdge(txId, holdTxId);
                    }
                }
            }
            // wake up the first transaction in waiting list
            while (lockData.waiting.size() > 0) {
                LockNode node = lockData.waiting.peekFirst();
                log.debug("try to awake transaction...{},waiting list size:{}", node.txId, lockData.waiting.size());
                if (!tryAcquire(node.lockMode, node.txId, pageId)) {
                    return;
                }
                log.debug("get lock success...mode:{},txId:{},pageId:{},thread:{}", node.lockMode, node.txId, pageId, Thread.currentThread());
                lockData.waiting.pollFirst();
                // notify
                synchronized (node) {
                    log.debug("notify transaction...{}", node.txId);
                    node.notify();
                }
            }
        } finally {
            _latch.writeLock().unlock();
        }
    }

    @Override
    public Iterator<PageId> findAllLockPage(TransactionId txId) {
        if (!_holdingTable.containsKey(txId)) {
            List<PageId> emptyList = Collections.emptyList();
            return emptyList.iterator();
        }
        Set<PageId> pageIds = _holdingTable.get(txId);
        return pageIds.iterator();
    }

    @Override
    public void releaseAll(TransactionId txId) {
        _latch.writeLock().lock();
        try {
            if (_holdingTable.containsKey(txId)) {
                Set<PageId> rmPages = new HashSet<>();
                for (PageId pageId : _holdingTable.get(txId)) {
                    rmPages.add(pageId);
                }
                for (PageId pageId : rmPages) {
                    release(txId, pageId);
                }
            }
        } finally {
            _latch.writeLock().unlock();
        }
    }

    @Override
    public LockMode holdsLock(TransactionId txId, PageId pageId) {
        _latch.readLock().lock();
        try {
            if (!_lockTable.containsKey(pageId)) {
                return null;
            }
            return _lockTable.get(pageId).holding.get(txId);
        } finally {
            _latch.readLock().unlock();
        }
    }

    public boolean tryAcquire(LockManager.LockMode lockMode, TransactionId txId, PageId pageId) {
        // init lock table and holding table
        if (!_lockTable.containsKey(pageId)) {
            _latch.writeLock().lock();
            if (!_lockTable.containsKey(pageId)) {
                _lockTable.put(pageId, new LockData());
            }
            _latch.writeLock().unlock();
        }
        if (!_holdingTable.containsKey(txId)) {
            _latch.writeLock().lock();
            if (!_holdingTable.containsKey(txId)) {
                _holdingTable.put(txId, new HashSet<>());
            }
            _latch.writeLock().unlock();
        }
        _latch.writeLock().lock();
        try {
            LockData lockData = _lockTable.get(pageId);
            // synchronized (this) {
            if (lockData.holding.containsKey(txId)) {
                // already hold the lock
                LockMode mode = lockData.holding.get(txId);
                if (mode == LockMode.X_LOCK || mode == lockMode) {
                    return true;
                }
                // lock upgrade
                if (lockData.holding.size() == 1) {
                    lockData.lockMode = LockMode.X_LOCK;
                    lockData.holding.put(txId, LockMode.X_LOCK);
                    _holdingTable.get(txId).add(pageId);
                    return true;
                }
            } else {
                if (lockData.lockMode == null) {
                    lockData.lockMode = lockMode;
                    lockData.holding.put(txId, lockMode);
                    _holdingTable.get(txId).add(pageId);
                    return true;
                }
                if (lockData.waiting.size() == 0 && !LockMode.exclusive(lockData.lockMode, lockMode)) {
                    lockData.holding.put(txId, lockMode);
                    _holdingTable.get(txId).add(pageId);
                    return true;
                }
            }
            return false;
            //}
        } finally {
            _latch.writeLock().unlock();
        }
    }
}
