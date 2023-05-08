package com.entry.db;

import com.entry.db.common.Database;
import com.entry.db.common.Permissions;
import com.entry.db.execution.Predicate;
import com.entry.db.index.*;
import com.entry.db.storage.*;
import com.entry.db.systemtest.SimpleDbTestBase;
import com.entry.db.transaction.TransactionId;

import java.io.File;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import junit.framework.JUnit4TestAdapter;

public class BTreeFileInsertTest extends SimpleDbTestBase {
    private TransactionId tid;

    /**
     * Set up initial resources for each unit test.
     */
    @Before
    public void setUp() {
        tid = new TransactionId();
    }

    @After
    public void tearDown() {
        Database.getBufferPool().transactionComplete(tid);

        // set the page size back to the default
        BufferPool.resetPageSize();
        Database.reset();
    }

    @Test
    public void testSplitLeafPages() throws Exception {
        File emptyFile = File.createTempFile("empty", ".dat");
        emptyFile.deleteOnExit();
        Database.reset();
        BTreeFile empty = BTreeUtility.createEmptyBTreeFile(emptyFile.getAbsolutePath(), 2, 0, 3);
        int tableid = empty.getId();
        int keyField = 0;

        // create the leaf page
        BTreePageId leftPageId = new BTreePageId(tableid, 2, BTreePageId.LEAF);
        BTreeLeafPage leftPage = BTreeUtility.createRandomLeafPage(leftPageId, 2, keyField,
                0, BTreeUtility.MAX_RAND_VALUE);

        // create the parent page
        BTreePageId parentId = new BTreePageId(tableid, 1, BTreePageId.INTERNAL);
        BTreeInternalPage parent = new BTreeInternalPage(parentId,
                BTreeInternalPage.createEmptyPageData(), keyField);

        // set the pointers
        leftPage.setParentId(parentId);

        Field field = new IntField(BTreeUtility.MAX_RAND_VALUE / 2);
        Map<PageId, Page> dirtypages = new HashMap<>();
        dirtypages.put(leftPageId, leftPage);
        dirtypages.put(parentId, parent);
        BTreeLeafPage page = empty.splitLeafPage(tid, leftPage, field);
        assertTrue(page.getLeftSiblingId() != null || page.getRightSiblingId() != null);
        BTreeLeafPage otherPage;
        if (page.getLeftSiblingId() != null) {
            otherPage = (BTreeLeafPage) dirtypages.get(page.getLeftSiblingId());
            assertTrue(field.compare(Predicate.Op.GREATER_THAN_OR_EQ,
                    otherPage.reverseIterator().next().getField(keyField)));
        } else { // page.getRightSiblingId() != null
            otherPage = (BTreeLeafPage) dirtypages.get(page.getRightSiblingId());
            assertTrue(field.compare(Predicate.Op.LESS_THAN_OR_EQ,
                    otherPage.iterator().next().getField(keyField)));
        }

        int totalTuples = page.getNumTuples() + otherPage.getNumTuples();
        assertEquals(BTreeUtility.getNumTuplesPerPage(2), totalTuples);
        assertTrue(BTreeUtility.getNumTuplesPerPage(2) / 2 == page.getNumTuples() ||
                BTreeUtility.getNumTuplesPerPage(2) / 2 + 1 == page.getNumTuples());
        assertTrue(BTreeUtility.getNumTuplesPerPage(2) / 2 == otherPage.getNumTuples() ||
                BTreeUtility.getNumTuplesPerPage(2) / 2 + 1 == otherPage.getNumTuples());
        assertEquals(1, parent.getNumEntries());
    }

    @Test
    public void testSplitInternalPages() throws Exception {
        File emptyFile = File.createTempFile("empty", ".dat");
        emptyFile.deleteOnExit();
        Database.reset();
        int entriesPerPage = BTreeUtility.getNumEntriesPerPage();
        BTreeFile empty = BTreeUtility.createEmptyBTreeFile(emptyFile.getAbsolutePath(), 2, 0, 3 + entriesPerPage);
        int tableid = empty.getId();
        int keyField = 0;

        // create the internal page
        BTreePageId leftPageId = new BTreePageId(tableid, 2, BTreePageId.INTERNAL);
        BTreeInternalPage leftPage = BTreeUtility.createRandomInternalPage(leftPageId, keyField, BTreePageId.LEAF,
                0, BTreeUtility.MAX_RAND_VALUE, 3);

        // create the parent page
        BTreePageId parentId = new BTreePageId(tableid, 1, BTreePageId.INTERNAL);
        BTreeInternalPage parent = new BTreeInternalPage(parentId,
                BTreeInternalPage.createEmptyPageData(), keyField);

        // set the pointers
        leftPage.setParentId(parentId);

        Field field = new IntField(BTreeUtility.MAX_RAND_VALUE / 2);
        Map<PageId, Page> dirtypages = new HashMap<>();
        dirtypages.put(leftPageId, leftPage);
        dirtypages.put(parentId, parent);
        BTreeInternalPage page = empty.splitInternalPage(tid, leftPage, field);
        BTreeInternalPage otherPage;
        assertEquals(1, parent.getNumEntries());
        BTreeEntry parentEntry = parent.iterator().next();
        if (parentEntry.getLeftChild().equals(page.getId())) {
            otherPage = (BTreeInternalPage) dirtypages.get(parentEntry.getRightChild());
            assertTrue(field.compare(Predicate.Op.LESS_THAN_OR_EQ,
                    otherPage.iterator().next().getKey()));
        } else { // parentEntry.getRightChild().equals(page.getId())
            otherPage = (BTreeInternalPage) dirtypages.get(parentEntry.getLeftChild());
            assertTrue(field.compare(Predicate.Op.GREATER_THAN_OR_EQ,
                    otherPage.reverseIterator().next().getKey()));
        }

        int totalEntries = page.getNumEntries() + otherPage.getNumEntries();
        assertEquals(entriesPerPage - 1, totalEntries);
        assertTrue(entriesPerPage / 2 == page.getNumEntries() ||
                entriesPerPage / 2 - 1 == page.getNumEntries());
        assertTrue(entriesPerPage / 2 == otherPage.getNumEntries() ||
                entriesPerPage / 2 - 1 == otherPage.getNumEntries());
    }

    @Test
    public void testReusePage() throws Exception {
        File emptyFile = File.createTempFile("empty", ".dat");
        emptyFile.deleteOnExit();
        Database.reset();
        BTreeFile empty = BTreeUtility.createEmptyBTreeFile(emptyFile.getAbsolutePath(), 2, 0, 3);
        int tableid = empty.getId();
        int keyField = 0;

        // create the leaf page
        Map<PageId, Page> dirtypages = new HashMap<>();
        empty.setEmptyPage(tid, 2);
        BTreePageId leftPageId = new BTreePageId(tableid, 3, BTreePageId.LEAF);
        BTreeLeafPage leftPage = BTreeUtility.createRandomLeafPage(leftPageId, 2, keyField,
                0, BTreeUtility.MAX_RAND_VALUE);

        // create the parent page
        BTreePageId parentId = new BTreePageId(tableid, 1, BTreePageId.INTERNAL);
        BTreeInternalPage parent = new BTreeInternalPage(parentId,
                BTreeInternalPage.createEmptyPageData(), keyField);

        // set the pointers
        leftPage.setParentId(parentId);

        Field field = new IntField(BTreeUtility.MAX_RAND_VALUE / 2);
        dirtypages.put(leftPageId, leftPage);
        dirtypages.put(parentId, parent);
        BTreeLeafPage page = empty.splitLeafPage(tid, leftPage, field);
        assertTrue(page.getLeftSiblingId() != null || page.getRightSiblingId() != null);
        BTreeLeafPage otherPage;
        if (page.getLeftSiblingId() != null) {
            otherPage = (BTreeLeafPage) Database.getBufferPool().getPage(tid, page.getLeftSiblingId(), Permissions.READ_ONLY);
            // otherPage = (BTreeLeafPage) dirtypages.get(page.getLeftSiblingId());
        } else { // page.getRightSiblingId() != null
            otherPage = (BTreeLeafPage) Database.getBufferPool().getPage(tid, page.getRightSiblingId(), Permissions.READ_ONLY);
            // otherPage = (BTreeLeafPage) dirtypages.get(page.getRightSiblingId());
        }

        assertTrue(page.getId().getPageNumber() == 2 || otherPage.getId().getPageNumber() == 2);
    }

    /**
     * JUnit suite target
     */
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(BTreeFileInsertTest.class);
    }
}
