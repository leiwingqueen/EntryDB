package com.entry.db.storage;

import com.entry.db.transaction.SimpleLockManager;

import javax.xml.stream.FactoryConfigurationError;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUReplacerImpl implements LRUReplacer {
    private Map<Integer, LRUNode> lruMap;
    private LRUNode head;
    private LRUNode tail;
    private ReentrantReadWriteLock latch;

    public LRUReplacerImpl() {
        // lru data structure init
        lruMap = new HashMap<>();
        head = new LRUNode(-1);
        tail = new LRUNode(-1);
        head.next = tail;
        tail.pre = head;
        latch = new ReentrantReadWriteLock();
    }

    @Override
    public boolean remove(int frameId) {
        latch.writeLock().lock();
        try {
            return lruRemove(frameId);
        } finally {
            latch.writeLock().unlock();
        }
    }

    @Override
    public boolean add(int frameId) {
        latch.writeLock().lock();
        try {
            return lruInsert(frameId);
        } finally {
            latch.writeLock().unlock();
        }
    }

    @Override
    public int victim() {
        latch.writeLock().lock();
        try {
            if (head.next == tail) {
                return -1;
            }
            LRUNode node = head.next;
            lruRemove(node.frameId);
            return node.frameId;
        } finally {
            latch.writeLock().unlock();
        }
    }

    private boolean lruRemove(int frameId) {
        if (!lruMap.containsKey(frameId)) {
            return false;
        }
        LRUNode lruNode = lruMap.get(frameId);
        LRUNode pre = lruNode.pre;
        LRUNode next = lruNode.next;
        pre.next = next;
        next.pre = pre;
        lruMap.remove(frameId);
        return true;
    }

    private boolean lruInsert(int frameId) {
        if (lruMap.containsKey(frameId)) {
            return false;
        }
        // append new node to the end
        LRUNode node = new LRUNode(frameId);
        LRUNode pre = tail.pre;
        pre.next = node;
        node.pre = pre;
        node.next = tail;
        tail.pre = node;
        lruMap.put(frameId, node);
        return true;
    }

    private static class LRUNode {
        int frameId;
        LRUNode pre;
        LRUNode next;

        public LRUNode(int frameId) {
            this.frameId = frameId;
        }
    }
}
