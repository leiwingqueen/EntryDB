package com.entry.db.execution;

import com.entry.db.common.DbException;
import com.entry.db.common.Type;
import com.entry.db.storage.Tuple;
import com.entry.db.storage.TupleDesc;
import com.entry.db.storage.Field;
import com.entry.db.storage.IntField;
import com.entry.db.transaction.TransactionAbortedException;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Knows how to compute some aggregate over a set of IntFields.
 */
public class IntegerAggregator implements Aggregator {

    private static final long serialVersionUID = 1L;
    private int groupByField;
    private Type groupByFieldType;
    private int aggregateField;
    private Op op;
    private Map<Field, Integer> map1;
    // avg operation need to save sum and count
    private Map<Field, Integer> map2;

    private TupleDesc tupleDesc;


    /**
     * Aggregate constructor
     *
     * @param gbfield     the 0-based index of the group-by field in the tuple, or
     *                    NO_GROUPING if there is no grouping
     * @param gbfieldtype the type of the group by field (e.g., Type.INT_TYPE), or null
     *                    if there is no grouping
     * @param afield      the 0-based index of the aggregate field in the tuple
     * @param what        the aggregation operator
     */

    public IntegerAggregator(int gbfield, Type gbfieldtype, int afield, Op what) {
        // some code goes here
        this.groupByField = gbfield;
        this.groupByFieldType = gbfieldtype;
        this.aggregateField = afield;
        this.op = what;
        this.map1 = new ConcurrentHashMap<>();
        this.map2 = new ConcurrentHashMap<>();
    }

    /**
     * Merge a new tuple into the aggregate, grouping as indicated in the
     * constructor
     *
     * @param tup the Tuple containing an aggregate field and a group-by field
     */
    public void mergeTupleIntoGroup(Tuple tup) {
        // to simplify the case, we assume that the memory can contain all the group
        // comment by leiwingqueen
        // some code goes here
        this.tupleDesc = tup.getTupleDesc();
        Field key = new IntField(NO_GROUPING);
        if (groupByField >= 0) {
            key = tup.getField(groupByField);
        }
        IntField value = (IntField) tup.getField(aggregateField);
        // MIN, MAX, SUM, AVG, COUNT
        switch (op) {
            case MIN:
                if (!map1.containsKey(key) || map1.get(key) > value.getValue()) {
                    map1.put(key, value.getValue());
                }
                break;
            case MAX:
                if (!map1.containsKey(key) || map1.get(key) < value.getValue()) {
                    map1.put(key, value.getValue());
                }
                break;
            case SUM:
                map1.put(key, map1.getOrDefault(key, 0) + value.getValue());
                break;
            case COUNT:
                map1.put(key, map1.getOrDefault(key, 0) + 1);
                break;
            case AVG:
                map1.put(key, map1.getOrDefault(key, 0) + value.getValue());
                map2.put(key, map2.getOrDefault(key, 0) + 1);
                break;
            default:
                // TODO:SUM_COUNT and SC_AVG will implement in later lab
                throw new IllegalStateException();
        }
    }

    /**
     * Create a OpIterator over group aggregate results.
     *
     * @return a OpIterator whose tuples are the pair (groupVal, aggregateVal)
     * if using group, or a single (aggregateVal) if no grouping. The
     * aggregateVal is determined by the type of aggregate specified in
     * the constructor.
     */
    public OpIterator iterator() {
        // some code goes here
        return new IntAggregatorIter(this);
    }

    private static class IntAggregatorIter extends Operator {
        private IntegerAggregator aggregator;
        private Iterator<Field> iter;

        public IntAggregatorIter(IntegerAggregator aggregator) {
            this.aggregator = aggregator;
            this.iter = aggregator.map1.keySet().iterator();
        }

        @Override
        public void rewind() throws DbException, TransactionAbortedException {
            this.iter = aggregator.map1.keySet().iterator();
        }

        @Override
        protected Tuple fetchNext() throws DbException, TransactionAbortedException {
            if (!iter.hasNext()) {
                return null;
            }
            Field key = iter.next();
            Tuple tuple = new Tuple(getTupleDesc());
            switch (aggregator.op) {
                case MIN:
                case MAX:
                case SUM:
                case COUNT:
                    if (aggregator.groupByField >= 0) {
                        tuple.setField(0, key);
                        tuple.setField(1, new IntField(aggregator.map1.get(key)));
                    } else {
                        tuple.setField(0, new IntField(aggregator.map1.get(key)));
                    }
                    break;
                case AVG:
                    int avg = aggregator.map1.get(key) / aggregator.map2.get(key);
                    if (aggregator.groupByField >= 0) {
                        tuple.setField(0, key);
                        tuple.setField(1, new IntField(avg));
                    } else {
                        tuple.setField(0, new IntField(avg));
                    }
                    break;
                default:
                    // TODO:SUM_COUNT and SC_AVG will implement in later lab
                    throw new IllegalStateException();
            }
            return tuple;
        }

        @Override
        public OpIterator[] getChildren() {
            return new OpIterator[0];
        }

        @Override
        public void setChildren(OpIterator[] children) {
            // do nothing. useless here
        }

        @Override
        public TupleDesc getTupleDesc() {
            if (aggregator.groupByField >= 0) {
                String groupByFieldName = aggregator.tupleDesc.getFieldName(aggregator.groupByField);
                String aggregateFieldName = aggregator.tupleDesc.getFieldName(aggregator.aggregateField);
                return new TupleDesc(new Type[]{aggregator.groupByFieldType, Type.INT_TYPE},
                        new String[]{groupByFieldName, String.format("%s(%s)", aggregator.op, aggregateFieldName)});
            } else {
                // CASE NO GROUP
                String aggregateFieldName = aggregator.tupleDesc.getFieldName(aggregator.aggregateField);
                return new TupleDesc(new Type[]{Type.INT_TYPE}, new String[]{String.format("%s(%s)", aggregator.op, aggregateFieldName)});
            }
        }
    }

}
