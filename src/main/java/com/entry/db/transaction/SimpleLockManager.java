package com.entry.db.transaction;

import com.entry.db.storage.RecordId;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// reference https://www.geeksforgeeks.org/implementation-of-locking-in-dbms/
// 《database system concepts》chapter figure 18.10
@Slf4j
public class SimpleLockManager implements LockManager {
    private Map<RecordId, LockData> _lockTable;
    // use to find all the tuple which transaction holds
    private Map<TransactionId, Set<RecordId>> _holdingTable;
    // deadlock detect
    private TxWaitForGraph _txWaitForGraph;

    private ReentrantReadWriteLock _latch;


    public SimpleLockManager() {
        _lockTable = new HashMap<>();
        _holdingTable = new HashMap<>();
        _txWaitForGraph = new TxWaitForGraphImpl();
        _latch = new ReentrantReadWriteLock();
    }

    @Override
    public void acquire(LockManager.LockMode lockMode, TransactionId txId, RecordId recordId) throws TransactionAbortedException {
        if (tryAcquire(lockMode, txId, recordId)) {
            log.debug("get lock success...mode:{},txId:{},recordId:{},thread:{}", lockMode, txId, recordId, Thread.currentThread());
            return;
        }
        log.debug("get lock fail...mode:{},txId:{},recordId:{},thread:{}", lockMode, txId, recordId, Thread.currentThread());
        // get lock fail. add transaction to waiting list and deadlock detect
        LockNode lockNode = new LockNode(lockMode, txId);
        ReentrantReadWriteLock.WriteLock writeLock = _latch.writeLock();
        writeLock.lock();
        try {
            LockData lockData = _lockTable.get(recordId);
            // deadlock detect
            for (TransactionId holdTxId : lockData.holding.keySet()) {
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
            }
            // add to waiting list
            lockData.waiting.add(lockNode);
        } finally {
            writeLock.unlock();
        }
        // wait
        while (true) {
            // check if already get the lock
            if (holdsLock(txId, recordId) != null && holdsLock(txId, recordId).getVal() >= lockMode.getVal()) {
                return;
            }
            // synchronized (lockNode) {
            try {
                lockNode.wait(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
                Thread.currentThread().interrupt();
                throw new TransactionAbortedException();
            }
            //}
        }
    }

    @Override
    public void release(TransactionId txId, RecordId recordId) {
        log.debug("lock release...txId:{},recordId:{},thread:{}", txId, recordId, Thread.currentThread());
        LockData lockData;
        _latch.readLock().lock();
        try {
            lockData = _lockTable.get(recordId);
            if (lockData == null) {
                return;
            }
        } finally {
            _latch.readLock().unlock();
        }
        // case: txId is in waiting list, remove it from waiting list
        _latch.writeLock().lock();
        try {
            if (lockData.waiting.remove(txId)) {
                log.debug("remove from waiting list...txId:{},pageId:{}", txId, recordId);
                for (TransactionId holdTxId : lockData.holding.keySet()) {
                    if (holdTxId.equals(txId)) {
                        continue;
                    }
                    _txWaitForGraph.removeEdge(txId, holdTxId);
                }
            }
            // release lock that the txId holds
            if (holdsLock(txId, recordId) != null) {
                // update lock table
                lockData.holding.remove(txId);
                lockData.lockMode = null;
                _holdingTable.get(txId).remove(recordId);
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
                if (!tryAcquire(node.lockMode, node.txId, recordId)) {
                    return;
                }
                log.debug("get lock success...mode:{},txId:{},pageId:{},thread:{}", node.lockMode, node.txId, recordId, Thread.currentThread());
                lockData.waiting.pollFirst();
                // notify
                // synchronized (node) {
                log.debug("notify transaction...{}", node.txId);
                node.notify();
                // }
            }
        } finally {
            _latch.writeLock().unlock();
        }
    }

    @Override
    public Iterator<RecordId> findAllLockPage(TransactionId txId) {
        _latch.readLock().lock();
        try {
            if (!_holdingTable.containsKey(txId)) {
                List<RecordId> emptyList = Collections.emptyList();
                return emptyList.iterator();
            }
            Set<RecordId> pageIds = _holdingTable.get(txId);
            return pageIds.iterator();
        } finally {
            _latch.readLock().unlock();
        }
    }

    @Override
    public synchronized void releaseAll(TransactionId txId) {
        _latch.writeLock().lock();
        try {
            if (_holdingTable.containsKey(txId)) {
                Set<RecordId> rmRecords = new HashSet<>();
                for (RecordId recordId : _holdingTable.get(txId)) {
                    rmRecords.add(recordId);
                }
                for (RecordId pageId : rmRecords) {
                    release(txId, pageId);
                }
            }
        } finally {
            _latch.writeLock().unlock();
        }
    }

    @Override
    public LockMode holdsLock(TransactionId txId, RecordId recordId) {
        _latch.readLock().lock();
        try {
            if (!_lockTable.containsKey(recordId)) {
                return null;
            }
            return _lockTable.get(recordId).holding.get(txId);
        } finally {
            _latch.readLock().unlock();
        }
    }

    public boolean tryAcquire(LockManager.LockMode lockMode, TransactionId txId, RecordId recordId) {
        // init lock table and holding table
        ReentrantReadWriteLock.WriteLock writeLock = _latch.writeLock();
        try {
            writeLock.lock();
            // init lock table and
            if (!_lockTable.containsKey(recordId)) {
                _lockTable.put(recordId, new LockData());
            }
            if (!_holdingTable.containsKey(txId)) {
                _holdingTable.put(txId, new HashSet<>());
            }
            LockData lockData = _lockTable.get(recordId);
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
                    _holdingTable.get(txId).add(recordId);
                    return true;
                }
            } else {
                if (lockData.lockMode == null) {
                    lockData.lockMode = lockMode;
                    lockData.holding.put(txId, lockMode);
                    _holdingTable.get(txId).add(recordId);
                    return true;
                }
                if (lockData.waiting.size() == 0 && !LockMode.exclusive(lockData.lockMode, lockMode)) {
                    lockData.holding.put(txId, lockMode);
                    _holdingTable.get(txId).add(recordId);
                    return true;
                }
            }
            return false;
        } finally {
            writeLock.unlock();
        }
    }

    private static class LockData {
        LockMode lockMode;
        Map<TransactionId, LockMode> holding;
        Deque<LockNode> waiting;

        public LockData() {
            this.lockMode = null;
            holding = new HashMap<>();
            waiting = new LinkedList<>();
        }
    }

    private static class LockNode {
        LockManager.LockMode lockMode;
        TransactionId txId;

        public LockNode(LockManager.LockMode lockMode, TransactionId txId) {
            this.lockMode = lockMode;
            this.txId = txId;
        }
    }
}
