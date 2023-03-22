package simpledb.execution;

import simpledb.common.DbException;
import simpledb.common.Type;
import simpledb.execution.Aggregator.Op;
import simpledb.storage.Tuple;
import simpledb.storage.TupleDesc;
import simpledb.transaction.TransactionAbortedException;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * The Aggregation operator that computes an aggregate (e.g., sum, avg, max,
 * min). Note that we only support aggregates over a single column, grouped by a
 * single column.
 */
public class Aggregate extends Operator {

    private static final long serialVersionUID = 1L;

    private Aggregator aggregator;
    private OpIterator child;
    private int aggregateField;
    private int groupByField;
    private Aggregator.Op op;
    private OpIterator opIterator;

    /**
     * Constructor.
     * <p>
     * Implementation hint: depending on the type of afield, you will want to
     * construct an {@link IntegerAggregator} or {@link StringAggregator} to help
     * you with your implementation of readNext().
     *
     * @param child  The OpIterator that is feeding us tuples.
     * @param afield The column over which we are computing an aggregate.
     * @param gfield The column over which we are grouping the result, or -1 if
     *               there is no grouping
     * @param aop    The aggregation operator to use
     */
    public Aggregate(OpIterator child, int afield, int gfield, Aggregator.Op aop) {
        // some code goes here
        TupleDesc tupleDesc = child.getTupleDesc();
        this.child = child;
        this.aggregateField = afield;
        this.groupByField = gfield;
        this.op = aop;
        Type fieldType = tupleDesc.getFieldType(afield);
        Type groupByFieldType = null;
        if (gfield >= 0) {
            groupByFieldType = tupleDesc.getFieldType(gfield);
        }
        if (fieldType == Type.INT_TYPE) {
            aggregator = new IntegerAggregator(gfield, groupByFieldType, afield, aop);
        } else {
            aggregator = new StringAggregator(gfield, groupByFieldType, afield, aop);
        }
    }

    /**
     * @return If this aggregate is accompanied by a groupby, return the groupby
     * field index in the <b>INPUT</b> tuples. If not, return
     * {@link Aggregator#NO_GROUPING}
     */
    public int groupField() {
        // some code goes here
        return groupByField;
    }

    /**
     * @return If this aggregate is accompanied by a group by, return the name
     * of the groupby field in the <b>OUTPUT</b> tuples. If not, return
     * null;
     */
    public String groupFieldName() {
        // some code goes here
        if (groupByField < 0) {
            return null;
        } else {
            return child.getTupleDesc().getFieldName(groupByField);
        }
    }

    /**
     * @return the aggregate field
     */
    public int aggregateField() {
        // some code goes here
        return aggregateField;
    }

    /**
     * @return return the name of the aggregate field in the <b>OUTPUT</b>
     * tuples
     */
    public String aggregateFieldName() {
        // some code goes here
        return child.getTupleDesc().getFieldName(aggregateField);
    }

    /**
     * @return return the aggregate operator
     */
    public Aggregator.Op aggregateOp() {
        // some code goes here
        return op;
    }

    public static String nameOfAggregatorOp(Aggregator.Op aop) {
        return aop.toString();
    }

    public void open() throws NoSuchElementException, DbException,
            TransactionAbortedException {
        // some code goes here
        super.open();
        child.open();
        while (child.hasNext()) {
            aggregator.mergeTupleIntoGroup(child.next());
        }
    }

    /**
     * Returns the next tuple. If there is a group by field, then the first
     * field is the field by which we are grouping, and the second field is the
     * result of computing the aggregate. If there is no group by field, then
     * the result tuple should contain one field representing the result of the
     * aggregate. Should return null if there are no more tuples.
     */
    protected Tuple fetchNext() throws TransactionAbortedException, DbException {
        // some code goes here
        if (this.opIterator == null) {
            this.opIterator = aggregator.iterator();
            this.opIterator.open();
        }
        if (!this.opIterator.hasNext()) {
            return null;
        }
        return opIterator.next();
    }

    public void rewind() throws DbException, TransactionAbortedException {
        // some code goes here
        this.opIterator = null;
    }

    /**
     * Returns the TupleDesc of this Aggregate. If there is no group by field,
     * this will have one field - the aggregate column. If there is a group by
     * field, the first field will be the group by field, and the second will be
     * the aggregate value column.
     * <p>
     * The name of an aggregate column should be informative. For example:
     * "aggName(aop) (child_td.getFieldName(afield))" where aop and afield are
     * given in the constructor, and child_td is the TupleDesc of the child
     * iterator.
     */
    public TupleDesc getTupleDesc() {
        // TODO: how to reuse the aggregator's implement
        TupleDesc tupleDesc = child.getTupleDesc();
        Type aggregateType = tupleDesc.getFieldType(aggregateField);
        if (op != Op.MAX && op != Op.MIN) {
            aggregateType = Type.INT_TYPE;
        }
        String aggregateFieldName = tupleDesc.getFieldName(aggregateField);
        if (groupByField >= 0) {
            String groupByFieldName = tupleDesc.getFieldName(groupByField);
            return new TupleDesc(new Type[]{tupleDesc.getFieldType(groupByField), aggregateType},
                    new String[]{groupByFieldName, String.format("%s(%s)", op, aggregateFieldName)});
        } else {
            // CASE NO GROUP
            return new TupleDesc(new Type[]{aggregateType}, new String[]{String.format("%s(%s)", op, aggregateFieldName)});
        }
    }

    public void close() {
        // some code goes here
        child.close();
        if (this.opIterator != null) {
            this.opIterator.close();
        }
        super.close();
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
