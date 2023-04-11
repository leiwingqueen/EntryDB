package com.entry.db.storage;

public class LogRecord {
    protected int logType;
    protected long transactionId;
    protected long offset;

    public LogRecord(int logType, long transactionId, long offset) {
        this.logType = logType;
        this.transactionId = transactionId;
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "LogRecord{" +
                "logType=" + logType +
                ", transactionId=" + transactionId +
                ", offset=" + offset +
                '}';
    }
}
