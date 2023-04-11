package com.entry.db.storage;

public class UpdateLogRecord extends LogRecord {
    private Page before;
    private Page after;

    public UpdateLogRecord(long transactionId, long offset, Page before, Page after) {
        super(LogFile.UPDATE_RECORD, transactionId, offset);
        this.before = before;
        this.after = after;
    }

    public Page getBefore() {
        return before;
    }

    public Page getAfter() {
        return after;
    }
}
