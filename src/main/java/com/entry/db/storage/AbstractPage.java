package com.entry.db.storage;

import com.entry.db.transaction.TransactionId;

import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AbstractPage implements Page {
    protected int _pinCount = 0;
    protected ReentrantReadWriteLock _latch;
    // prevent the same transaction from pinning the same page more than once
    protected Set<TransactionId> _pinSet;

    public AbstractPage() {
        this._pinCount = 0;
        this._latch = new ReentrantReadWriteLock();
    }

    @Override
    public void pin(TransactionId tid) {
        this._latch.writeLock().lock();
        if (!_pinSet.contains(tid)) {
            this._pinCount++;
            _pinSet.add(tid);
        }
        this._latch.writeLock().unlock();
    }

    @Override
    public void unpin(TransactionId tid) {
        this._latch.writeLock().lock();
        if (this._pinCount > 0 && _pinSet.contains(tid)) {
            this._pinCount--;
            this._pinSet.remove(tid);
        }
        this._latch.writeLock().unlock();
    }

    @Override
    public boolean isPinned() {
        this._latch.readLock().lock();
        try {
            return this._pinCount > 0;
        } finally {
            this._latch.readLock().unlock();
        }
    }
}
