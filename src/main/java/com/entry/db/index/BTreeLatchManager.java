package com.entry.db.index;

import com.entry.db.storage.PageId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BTreeLatchManager {
    private Map<PageId, ReentrantReadWriteLock> _latchMap;

    public BTreeLatchManager() {
        _latchMap = new ConcurrentHashMap<>();
    }

    public void acquireReadLatch(PageId pageId) {
        _latchMap.computeIfAbsent(pageId, k -> new ReentrantReadWriteLock()).readLock().lock();
    }

    public void releaseReadLatch(PageId pageId) {
        _latchMap.computeIfAbsent(pageId, k -> new ReentrantReadWriteLock()).readLock().unlock();
    }

    public void acquireWriteLatch(PageId pageId) {
        _latchMap.computeIfAbsent(pageId, k -> new ReentrantReadWriteLock()).writeLock().lock();
    }

    public void releaseWriteLatch(PageId pageId) {
        _latchMap.computeIfAbsent(pageId, k -> new ReentrantReadWriteLock()).writeLock().unlock();
    }
}
