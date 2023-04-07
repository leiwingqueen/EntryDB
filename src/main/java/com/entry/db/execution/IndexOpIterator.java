package com.entry.db.execution;

import com.entry.db.common.DbException;
import com.entry.db.transaction.TransactionAbortedException;

import java.util.NoSuchElementException;

/**
 * IndexDBIterator is the interface that index access methods
 * implement in SimpleDb.
 */
public interface IndexOpIterator extends OpIterator {
    /**
     * Open the access method such that when getNext is called, it
     * iterates through the tuples that satisfy ipred.
     *
     * @param ipred The predicate that is used to scan the index.
     */
    void open(IndexPredicate ipred)
            throws NoSuchElementException, DbException, TransactionAbortedException;

    /**
     * Begin a new index scan with the specified predicate.
     *
     * @param ipred The predicate that is used to scan the index.
     */
    void rewind(IndexPredicate ipred)
            throws DbException, TransactionAbortedException;
}
