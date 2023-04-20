package com.entry.db.transaction;

import com.entry.db.storage.RecordId;

import java.util.Iterator;

// page level lock manager
// reference https://www.geeksforgeeks.org/implementation-of-locking-in-dbms/
public interface LockManager {

    void acquire(LockMode lockMode, TransactionId txId, RecordId recordId) throws TransactionAbortedException;

    void release(TransactionId txId, RecordId recordId);

    Iterator<RecordId> findAllLocks(TransactionId txId);

    void releaseAll(TransactionId txId);

    LockMode holdsLock(TransactionId txId, RecordId recordId);

    enum LockMode {
        S_LOCK(0),
        X_LOCK(1),
        ;

        private int val;

        LockMode(int val) {
            this.val = val;
        }

        public static boolean exclusive(LockMode l1, LockMode l2) {
            if (S_LOCK == l1 && S_LOCK == l2) {
                return false;
            } else {
                return true;
            }
        }

        public int getVal() {
            return val;
        }
    }
}
