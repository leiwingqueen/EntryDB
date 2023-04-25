package com.entry.db.transaction;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TxWaitForGraphImpl implements TxWaitForGraph {
    // nodes
    private Set<TransactionId> _nodes;
    // edges
    private Map<TransactionId, Set<TransactionId>> _edges;

    private ReentrantReadWriteLock _latch;

    public TxWaitForGraphImpl() {
        _nodes = new HashSet<>();
        _edges = new HashMap<>();
        _latch = new ReentrantReadWriteLock();
    }

    @Override
    public boolean addEdge(TransactionId from, TransactionId to) {
        _latch.writeLock().lock();
        try {
            _nodes.add(from);
            _nodes.add(to);
            if (!_edges.containsKey(from)) {
                _edges.put(from, new HashSet<>());
            }
            _edges.get(from).add(to);
            if (containsCircle()) {
                _edges.get(from).remove(to);
                return false;
            }
            return true;
        } finally {
            _latch.writeLock().unlock();
        }
    }

    @Override
    public void removeEdge(TransactionId from, TransactionId to) {
        _latch.writeLock().lock();
        try {
            if (!_edges.containsKey(from)) {
                return;
            }
            _edges.get(from).remove(to);
        } finally {
            _latch.writeLock().unlock();
        }
    }


    // dfs with color
    @Override
    public boolean containsCircle() {
        _latch.readLock().lock();
        try {
            Map<TransactionId, Color> colorMap = new HashMap<>(_nodes.size());
            for (TransactionId node : _nodes) {
                colorMap.put(node, Color.WHITE);
            }
            for (TransactionId node : _nodes) {
                if (colorMap.get(node) == Color.WHITE) {
                    if (dfs(node, colorMap)) {
                        return true;
                    }
                }
            }
            return false;
        } finally {
            _latch.readLock().unlock();
        }
    }

    private boolean dfs(TransactionId cur, Map<TransactionId, Color> colors) {
        colors.put(cur, Color.GRAY);
        if (_edges.containsKey(cur)) {
            for (TransactionId next : _edges.get(cur)) {
                if (colors.get(next) == Color.GRAY) {
                    return true;
                }
                if (colors.get(next) == Color.WHITE && dfs(next, colors)) {
                    return true;
                }
            }
        }
        colors.put(cur, Color.BLACK);
        return false;
    }

    private enum Color {
        WHITE,
        GRAY,
        BLACK;
    }
}
