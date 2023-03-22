package simpledb.transaction;

import simpledb.common.Debug;
import simpledb.storage.PageId;

import java.util.*;

// reference https://www.geeksforgeeks.org/implementation-of-locking-in-dbms/
// 《database system concepts》chapter figure 18.10
public class SimpleLockManager implements LockManager {
    private Map<PageId, LockData> _lockTable;
    // use to find all the page which transaction holds
    private Map<TransactionId, Set<PageId>> _holdingTable;
    // deadlock detect
    private TxWaitForGraph _txWaitForGraph;

    public SimpleLockManager() {
        _lockTable = new HashMap<>();
        _holdingTable = new HashMap<>();
        _txWaitForGraph = new TxWaitForGraphImpl();
    }

    @Override
    public void acquire(LockManager.LockMode lockMode, TransactionId txId, PageId pageId) throws TransactionAbortedException {
        if (tryAcquire(lockMode, txId, pageId)) {
            Debug.log(1, "get lock success...mode:%s,txId:%s,pageId:%s,thread:%s", lockMode, txId, pageId, Thread.currentThread());
            return;
        }
        Debug.log(1, "get lock fail...mode:%s,txId:%s,pageId:%s", lockMode, txId, pageId);
        LockNode lockNode = new LockNode(lockMode, txId);
        synchronized (this) {
            LockData lockData = _lockTable.get(pageId);
            // deadlock detect
            for (TransactionId holdTxId : lockData.holding.keySet()) {
                // case: tx1 and tx2 both hold the share lock, and tx1 is waiting for the exclusive lock
                if (holdTxId.equals(txId)) {
                    continue;
                }
                if (!_txWaitForGraph.addEdge(txId, holdTxId)) {
                    Debug.log(1, "dead lock found,throw TxAbortException");
                    for (TransactionId to : lockData.holding.keySet()) {
                        _txWaitForGraph.removeEdge(txId, to);
                    }
                    throw new TransactionAbortedException();
                }
            }
            // add to waiting list
            lockData.waiting.add(lockNode);
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
        Debug.log("lock release...txId:%s,pageId:%s,thread:%s", txId, pageId, Thread.currentThread());
        LockData lockData;
        synchronized (this) {
            lockData = _lockTable.get(pageId);
            if (lockData == null) {
                return;
            }
        }
        // case: txId is in waiting list, remove it from waiting list
        synchronized (this) {
            if (lockData.waiting.remove(txId)) {
                Debug.log("remove from waiting list...txId:%d,pageId:%s", txId.getId(), pageId);
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
                Debug.log("try to awake transaction...%s,waiting list size:%d", node.txId, lockData.waiting.size());
                if (!tryAcquire(node.lockMode, node.txId, pageId)) {
                    return;
                }
                Debug.log(1, "get lock success...mode:%s,txId:%s,pageId:%s,thread:%s", node.lockMode, node.txId, pageId, Thread.currentThread());
                lockData.waiting.pollFirst();
                // notify
                synchronized (node) {
                    Debug.log("notify transaction...%s", node.txId);
                    node.notify();
                }
            }
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
    public synchronized void releaseAll(TransactionId txId) {
        if (_holdingTable.containsKey(txId)) {
            Set<PageId> rmPages = new HashSet<>();
            for (PageId pageId : _holdingTable.get(txId)) {
                rmPages.add(pageId);
            }
            for (PageId pageId : rmPages) {
                release(txId, pageId);
            }
        }
    }

    @Override
    public LockMode holdsLock(TransactionId txId, PageId pageId) {
        if (!_lockTable.containsKey(pageId)) {
            return null;
        }
        return _lockTable.get(pageId).holding.get(txId);
    }

    public boolean tryAcquire(LockManager.LockMode lockMode, TransactionId txId, PageId pageId) {
        // init lock table and holding table
        if (!_lockTable.containsKey(pageId)) {
            synchronized (this) {
                if (!_lockTable.containsKey(pageId)) {
                    _lockTable.put(pageId, new LockData());
                }
            }
        }
        if (!_holdingTable.containsKey(txId)) {
            synchronized (this) {
                if (!_holdingTable.containsKey(txId)) {
                    _holdingTable.put(txId, new HashSet<>());
                }
            }
        }
        LockData lockData = _lockTable.get(pageId);
        synchronized (this) {
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
