package com.entry.db.transaction;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class LockData {
    LockManager.LockMode lockMode;
    Map<TransactionId, LockManager.LockMode> holding;
    Deque<LockNode> waiting;

    public LockData() {
        this.lockMode = null;
        holding = new HashMap<>();
        waiting = new LinkedList<>();
    }

    @Override
    public String toString() {
        List<String> holdingList = new ArrayList<>();
        for (Map.Entry<TransactionId, LockManager.LockMode> entry : holding.entrySet()) {
            holdingList.add(entry.getKey() + ":" + entry.getValue());
        }
        Map<LockManager.LockMode, Integer> waitMap = new HashMap<>();
        for (LockNode lockNode : waiting) {
            waitMap.put(lockNode.lockMode, waitMap.getOrDefault(lockNode.lockMode, 0) + 1);
        }
        List<TransactionId> xLockWaitList = new ArrayList<>();
        for (LockNode lockNode : waiting) {
            if (lockNode.lockMode == LockManager.LockMode.X_LOCK) {
                xLockWaitList.add(lockNode.txId);
            }
        }
        return "LockData{" +
                "lockMode=" + lockMode +
                ", holding=" + StringUtils.join(holdingList, ",") +
                ", S-LOCK waiting=" + waitMap.getOrDefault(LockManager.LockMode.S_LOCK, 0) +
                ", X-LOCK waiting=" + waitMap.getOrDefault(LockManager.LockMode.X_LOCK, 0) +
                ",X-LOCK waiting detail=" + StringUtils.join(xLockWaitList, ",") +
                '}';
    }
}
