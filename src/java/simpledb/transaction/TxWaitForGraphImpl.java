package simpledb.transaction;

import java.util.*;

public class TxWaitForGraphImpl implements TxWaitForGraph {
    // nodes
    private Set<TransactionId> _nodes;
    // edges
    private Map<TransactionId, Set<TransactionId>> _edges;

    public TxWaitForGraphImpl() {
        _nodes = new HashSet<>();
        _edges = new HashMap<>();
    }

    @Override
    public synchronized boolean addEdge(TransactionId from, TransactionId to) {
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
    }

    @Override
    public synchronized void removeEdge(TransactionId from, TransactionId to) {
        if (!_edges.containsKey(from)) {
            return;
        }
        _edges.get(from).remove(to);
    }


    // dfs with color
    @Override
    public boolean containsCircle() {
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
