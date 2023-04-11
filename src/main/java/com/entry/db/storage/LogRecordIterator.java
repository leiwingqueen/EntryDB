package com.entry.db.storage;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;

@Slf4j
public class LogRecordIterator implements Iterator<LogRecord> {
    private RandomAccessFile raf;
    private long offset;
    private LogRecord nextRecord;

    public LogRecordIterator(RandomAccessFile raf, long offset) throws IOException {
        this.raf = raf;
        this.offset = offset;
        nextRecord = null;
        this.raf.seek(offset);
    }

    @Override
    public boolean hasNext() {
        if (nextRecord != null) {
            return true;
        }
        // fetch next record
        try {
            fetchNext();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return nextRecord != null;
    }

    private void fetchNext() throws IOException {
        if (raf.getFilePointer() >= raf.length()) {
            return;
        }
        // update record format:
        // | type | tid | | before image | after image | offset |
        // commit / begin / abort record format:
        // | type | tid | offset |
        // checkpoint record format:
        // | type | tid | num of xactions | xid | offset | ... | offset |
        int type = raf.readInt();
        long tid, logOffset;
        switch (type) {
            case LogFile.UPDATE_RECORD:
                tid = raf.readLong();
                Page before = LogFile.readPageData(raf);
                Page after = LogFile.readPageData(raf);
                logOffset = raf.readLong();
                nextRecord = new UpdateLogRecord(tid, logOffset, before, after);
                break;
            case LogFile.BEGIN_RECORD:
            case LogFile.COMMIT_RECORD:
            case LogFile.ABORT_RECORD:
                tid = raf.readLong();
                logOffset = raf.readLong();
                nextRecord = new SpLogRecord(type, tid, logOffset);
                break;
            case LogFile.CHECKPOINT_RECORD:
                tid = raf.readLong();
                int numTx = raf.readInt();
                CheckpointLogRecord checkpointLogRecord = new CheckpointLogRecord(offset);
                for (int i = 0; i < numTx; i++) {
                    long[] txOffset = new long[2];
                    txOffset[0] = raf.readLong();
                    txOffset[1] = raf.readLong();
                    checkpointLogRecord.addTxOffset(txOffset);
                }
                logOffset = raf.readLong();
                checkpointLogRecord.offset = logOffset;
                nextRecord = checkpointLogRecord;
                break;
        }
        log.debug("fetch next record...{}", nextRecord);
    }

    @Override
    public LogRecord next() {
        if (!hasNext()) {
            LogRecord res = nextRecord;
            nextRecord = null;
            return res;
        }
        return nextRecord;
    }
}
