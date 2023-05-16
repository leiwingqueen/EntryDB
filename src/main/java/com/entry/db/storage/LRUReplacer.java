package com.entry.db.storage;

// a helper class for BufferPoolManager, use for implement LRU replacement policy
public interface LRUReplacer {
    // pin the page with given frameId, return true if success
    boolean remove(int frameId);

    // unpin the page with given frameId, return true if success
    boolean add(int frameId);

    // return the frameId of the victim page
    int victim();
}
