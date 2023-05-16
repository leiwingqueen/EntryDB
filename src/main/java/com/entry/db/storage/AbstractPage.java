package com.entry.db.storage;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AbstractPage implements Page {
    protected int _pinCount = 0;
    protected ReentrantReadWriteLock _latch;

    public AbstractPage() {
        this._pinCount = 0;
        this._latch = new ReentrantReadWriteLock();
    }

    @Override
    public void pin() {
        this._latch.writeLock().lock();
        this._pinCount++;
        this._latch.writeLock().unlock();
    }

    @Override
    public void unpin() {
        this._latch.writeLock().lock();
        if (this._pinCount > 0) {
            this._pinCount--;
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
