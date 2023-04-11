package com.entry.db.storage;

import java.util.ArrayList;
import java.util.List;

public class CheckpointLogRecord extends LogRecord {
    //[{txId, offset}, {txId, offset}, ...]
    private List<long[]> txOffsets;

    public CheckpointLogRecord(long offset) {
        super(LogFile.CHECKPOINT_RECORD, -1, offset);
        this.txOffsets = new ArrayList<>();
    }

    public void addTxOffset(long[] txOffset) {
        this.txOffsets.add(txOffset);
    }
}
