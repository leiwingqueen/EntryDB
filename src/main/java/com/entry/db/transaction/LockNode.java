package com.entry.db.transaction;

public class LockNode {
    LockManager.LockMode lockMode;
    TransactionId txId;

    public LockNode(LockManager.LockMode lockMode, TransactionId txId) {
        this.lockMode = lockMode;
        this.txId = txId;
    }

    @Override
    public String toString() {
        return "LockNode{" +
                "lockMode=" + lockMode +
                ", txId=" + txId +
                '}';
    }
}
