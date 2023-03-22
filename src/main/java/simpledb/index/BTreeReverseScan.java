package simpledb.index;

import simpledb.common.Database;
import simpledb.common.DbException;
import simpledb.common.Type;
import simpledb.execution.IndexPredicate;
import simpledb.execution.OpIterator;
import simpledb.storage.DbFileIterator;
import simpledb.storage.Tuple;
import simpledb.storage.TupleDesc;
import simpledb.transaction.TransactionAbortedException;
import simpledb.transaction.TransactionId;

import java.util.NoSuchElementException;

// extra credit
// BTreeReverseScan is an operator which reads tuples in reverse sorted order
// add by leiwingqueen 2023-03-16
public class BTreeReverseScan implements OpIterator {
    private static final long serialVersionUID = 1L;

    private boolean isOpen = false;
    private final TransactionId tid;
    private TupleDesc myTd;
    private IndexPredicate ipred = null;
    private transient DbFileIterator it;
    private String tablename;
    private String alias;

    public BTreeReverseScan(TransactionId tid, int tableid, String tableAlias, IndexPredicate ipred) {
        this.tid = tid;
        this.ipred = ipred;
        reset(tableid, tableAlias);
    }

    public void reset(int tableid, String tableAlias) {
        this.isOpen = false;
        this.alias = tableAlias;
        this.tablename = Database.getCatalog().getTableName(tableid);
        if (ipred == null) {
            this.it = Database.getCatalog().getDatabaseFile(tableid).reverseIterator(tid);
        } else {
            this.it = ((BTreeFile) Database.getCatalog().getDatabaseFile(tableid)).indexReverseIterator(tid, ipred);
        }
        myTd = Database.getCatalog().getTupleDesc(tableid);
        String[] newNames = new String[myTd.numFields()];
        Type[] newTypes = new Type[myTd.numFields()];
        for (int i = 0; i < myTd.numFields(); i++) {
            String name = myTd.getFieldName(i);
            Type t = myTd.getFieldType(i);

            newNames[i] = tableAlias + "." + name;
            newTypes[i] = t;
        }
        myTd = new TupleDesc(newTypes, newNames);
    }

    @Override
    public void open() throws DbException, TransactionAbortedException {
        if (isOpen)
            throw new DbException("double open on one OpIterator.");

        it.open();
        isOpen = true;
    }

    @Override
    public boolean hasNext() throws DbException, TransactionAbortedException {
        if (!isOpen)
            throw new IllegalStateException("iterator is closed");
        return it.hasNext();
    }

    @Override
    public Tuple next() throws DbException, TransactionAbortedException, NoSuchElementException {
        if (!isOpen)
            throw new IllegalStateException("iterator is closed");

        return it.next();
    }

    @Override
    public void rewind() throws DbException, TransactionAbortedException {
        close();
        open();
    }

    @Override
    public TupleDesc getTupleDesc() {
        return myTd;
    }

    @Override
    public void close() {
        it.close();
        isOpen = false;
    }
}
