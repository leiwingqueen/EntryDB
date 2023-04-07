package com.entry.db.systemtest;

import java.io.IOException;

import com.entry.db.storage.HeapFile;
import org.junit.Test;

import com.entry.db.common.Database;
import com.entry.db.common.DbException;
import com.entry.db.transaction.Transaction;
import com.entry.db.transaction.TransactionAbortedException;

import static org.junit.Assert.*;

public class TransactionTestAllDirty extends SimpleDbTestBase {
    @Test public void testAllDirtyFails()
            throws IOException, DbException, TransactionAbortedException {
        // Allocate a file with ~10 pages of data
        HeapFile f = SystemTestUtil.createRandomHeapFile(2, 512*10, null, null);
        Database.resetBufferPool(1);

        // BEGIN TRANSACTION
        Transaction t = new Transaction();
        t.start();

        // Insert a new row
        AbortEvictionTest.insertRow(f, t);

        // Scanning the table must fail because it can't evict the dirty page
        try {
            AbortEvictionTest.findMagicTuple(f, t);
            fail("Expected scan to run out of available buffer pages");
        } catch (DbException ignored) {}
        t.commit();
    }

    /** Make test compatible with older version of ant. */
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TransactionTestAllDirty.class);
    }
}
