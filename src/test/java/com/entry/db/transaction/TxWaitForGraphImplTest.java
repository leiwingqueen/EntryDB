package com.entry.db.transaction;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// add by leiwingqueen 2023-03-03
public class TxWaitForGraphImplTest {
    @Test
    public void addEdge() {
        TxWaitForGraph waitForGraph = new TxWaitForGraphImpl();
        TransactionId tx1 = new TransactionId();
        TransactionId tx2 = new TransactionId();
        TransactionId tx3 = new TransactionId();
        boolean r1 = waitForGraph.addEdge(tx1, tx2);
        boolean r2 = waitForGraph.addEdge(tx2, tx3);
        boolean r3 = waitForGraph.addEdge(tx3, tx1);
        Assert.assertEquals(true, r1);
        Assert.assertEquals(true, r2);
        Assert.assertEquals(false, r3);
        waitForGraph.removeEdge(tx3, tx1);
        boolean r4 = waitForGraph.containsCircle();
        Assert.assertEquals(false, r4);
    }

    @Test
    public void test_color_1() {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0},
        };
        boolean res = containsCircleWithColor(n, edges);
        Assert.assertEquals(true, res);
    }

    @Test
    public void test_color_2() {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {3, 4},
        };
        boolean res = containsCircleWithColor(n, edges);
        Assert.assertEquals(false, res);
    }

    // check circle with color
    private boolean containsCircleWithColor(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
        }
        // 0-white,1-gray,2-black
        Color[] colors = new Color[n];
        for (int i = 0; i < n; i++) {
            colors[i] = Color.WHITE;
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] == Color.WHITE.WHITE) {
                if (dfsWithColor(graph, i, colors)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsWithColor(List<Integer>[] graph, int cur, Color[] colors) {
        colors[cur] = Color.GRAY;
        for (Integer next : graph[cur]) {
            if (colors[next] == Color.GRAY) {
                return true;
            } else if (colors[next] == Color.WHITE) {
                if (dfsWithColor(graph, next, colors)) {
                    return true;
                }
            }
        }
        colors[cur] = Color.BLACK;
        return false;
    }

    private enum Color {
        WHITE,
        GRAY,
        BLACK;
    }
}