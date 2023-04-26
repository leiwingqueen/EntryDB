package com.entry.db.transaction;

import com.entry.db.storage.PageId;

import java.util.*;

// reference https://www.geeksforgeeks.org/wait-for-graph-deadlock-detection-in-distributed-system/
public class TxWaitForGraphV2 {
    /**
     * check if there is a circle in the graph
     *
     * @param lockTable lock table
     * @param txId      request transaction id
     * @return
     */
    public boolean containsCircle(Map<PageId, LockData> lockTable, Map<TransactionId, PageId> waitForResource,
                                  TransactionId txId) {
        Set<TransactionId> visit = new HashSet<>();
        visit.add(txId);
        Queue<TransactionId> queue = new LinkedList<>();
        queue.add(txId);
        while (queue.size() > 0) {
            TransactionId id = queue.poll();
            if (waitForResource.containsKey(id)) {
                PageId pageId = waitForResource.get(id);
                LockData lockData = lockTable.get(pageId);
                for (TransactionId hold : lockData.holding.keySet()) {
                    if (visit.contains(hold)) {
                        return true;
                    }
                    visit.add(hold);
                    queue.add(hold);
                }
            }
        }
        return false;
    }
}
