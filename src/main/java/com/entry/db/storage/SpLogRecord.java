package com.entry.db.storage;

// begin, commit, abort statements
public class SpLogRecord extends LogRecord {
    public SpLogRecord(int logType, long transactionId, long offset) {
        super(logType, transactionId, offset);
    }


}
