package com.entry.db.execution;

import com.entry.db.common.Database;
import com.entry.db.common.DbException;
import com.entry.db.common.Type;
import com.entry.db.storage.BufferPool;
import com.entry.db.storage.IntField;
import com.entry.db.storage.Tuple;
import com.entry.db.storage.TupleDesc;
import com.entry.db.transaction.TransactionAbortedException;
import com.entry.db.transaction.TransactionId;

import java.io.IOException;

/**
 * The delete operator. Delete reads tuples from its child operator and removes
 * them from the table they belong to.
 */
public class Delete extends Operator {

    private static final long serialVersionUID = 1L;

    private TransactionId txId;
    private OpIterator child;
    private boolean end;

    /**
     * Constructor specifying the transaction that this delete belongs to as
     * well as the child to read from.
     *
     * @param t     The transaction this delete runs in
     * @param child The child operator from which to read tuples for deletion
     */
    public Delete(TransactionId t, OpIterator child) {
        // some code goes here
        this.txId = t;
        this.child = child;
        this.end = false;
    }

    public TupleDesc getTupleDesc() {
        // some code goes here
        return new TupleDesc(new Type[]{Type.INT_TYPE});
    }

    public void open() throws DbException, TransactionAbortedException {
        // some code goes here
        super.open();
        child.open();
    }

    public void close() {
        // some code goes here
        super.close();
        child.close();
    }

    public void rewind() throws DbException, TransactionAbortedException {
        // some code goes here
        child.rewind();
        end = false;
    }

    /**
     * Deletes tuples as they are read from the child operator. Deletes are
     * processed via the buffer pool (which can be accessed via the
     * Database.getBufferPool() method.
     *
     * @return A 1-field tuple containing the number of deleted records.
     * @see Database#getBufferPool
     * @see BufferPool#deleteTuple
     */
    protected Tuple fetchNext() throws TransactionAbortedException, DbException {
        // some code goes here
        if (end) {
            return null;
        }
        end = true;
        BufferPool bufferPool = Database.getBufferPool();
        int rows = 0;
        while (child.hasNext()) {
            Tuple tuple = child.next();
            try {
                bufferPool.deleteTuple(txId, tuple);
            } catch (IOException e) {
                e.printStackTrace();
                throw new DbException("delete tuple error");
            }
            rows++;
        }
        Tuple resTuple = new Tuple(getTupleDesc());
        resTuple.setField(0, new IntField(rows));
        return resTuple;
    }

    @Override
    public OpIterator[] getChildren() {
        // some code goes here
        return new OpIterator[]{child};
    }

    @Override
    public void setChildren(OpIterator[] children) {
        // some code goes here
        this.child = children[0];
    }

}
