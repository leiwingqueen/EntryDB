package com.entry.db.execution;

import com.entry.db.common.DbException;
import com.entry.db.common.Type;
import com.entry.db.storage.*;
import com.entry.db.transaction.TransactionAbortedException;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Knows how to compute some aggregate over a set of StringFields.
 */
public class StringAggregator implements Aggregator {

    private static final long serialVersionUID = 1L;

    private int groupByField;
    private Type groupByFieldType;
    private int aggregateField;
    private Op op;
    // use for max,min
    private Map<Field, StringField> map1;
    // data count.
    private Map<Field, Integer> map2;

    private TupleDesc tupleDesc;

    /**
     * Aggregate constructor
     *
     * @param gbfield     the 0-based index of the group-by field in the tuple, or NO_GROUPING if there is no grouping
     * @param gbfieldtype the type of the group by field (e.g., Type.INT_TYPE), or null if there is no grouping
     * @param afield      the 0-based index of the aggregate field in the tuple
     * @param what        aggregation operator to use -- only supports COUNT
     * @throws IllegalArgumentException if what != COUNT
     */

    public StringAggregator(int gbfield, Type gbfieldtype, int afield, Op what) {
        // some code goes here
        this.groupByField = gbfield;
        this.groupByFieldType = gbfieldtype;
        this.aggregateField = afield;
        this.op = what;
        map1 = new ConcurrentHashMap<>();
        map2 = new ConcurrentHashMap<>();
    }

    /**
     * Merge a new tuple into the aggregate, grouping as indicated in the constructor
     *
     * @param tup the Tuple containing an aggregate field and a group-by field
     */
    public void mergeTupleIntoGroup(Tuple tup) {
        // some code goes here
        this.tupleDesc = tup.getTupleDesc();
        Field key = new IntField(NO_GROUPING);
        if (groupByField >= 0) {
            key = tup.getField(groupByField);
        }
        StringField value = (StringField) tup.getField(aggregateField);
        // MIN, MAX, SUM, AVG, COUNT
        switch (op) {
            case MIN:
                if (!map1.containsKey(key) || map1.get(key).compare(Predicate.Op.LESS_THAN, value)) {
                    map1.put(key, value);
                }
                break;
            case MAX:
                if (!map1.containsKey(key) || map1.get(key).compare(Predicate.Op.GREATER_THAN, value)) {
                    map1.put(key, value);
                }
                break;
            case SUM:
            case AVG:
                map1.put(key, value);
                break;
            case COUNT:
                map1.put(key, value);
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
     * @return a OpIterator whose tuples are the pair (groupVal,
     * aggregateVal) if using group, or a single (aggregateVal) if no
     * grouping. The aggregateVal is determined by the type of
     * aggregate specified in the constructor.
     */
    public OpIterator iterator() {
        // some code goes here
        return new StringAggregatorIter(this);
    }

    private static class StringAggregatorIter extends Operator {
        private StringAggregator aggregator;
        private Iterator<Field> iter;

        public StringAggregatorIter(StringAggregator aggregator) {
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
                    if (aggregator.groupByField >= 0) {
                        tuple.setField(0, key);
                        tuple.setField(1, aggregator.map1.get(key));
                    } else {
                        tuple.setField(0, aggregator.map1.get(key));
                    }
                    break;
                case AVG:
                case SUM:
                    if (aggregator.groupByField >= 0) {
                        tuple.setField(0, key);
                        tuple.setField(1, new IntField(0));
                    } else {
                        tuple.setField(0, aggregator.map1.get(key));
                    }
                case COUNT:
                    if (aggregator.groupByField >= 0) {
                        tuple.setField(0, key);
                        tuple.setField(1, new IntField(aggregator.map2.get(key)));
                    } else {
                        tuple.setField(0, new IntField(aggregator.map2.get(key)));
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
                Type type = Type.INT_TYPE;
                if (aggregator.op == Op.MAX || aggregator.op == Op.MIN) {
                    type = Type.STRING_TYPE;
                }
                String groupByFieldName = aggregator.tupleDesc.getFieldName(aggregator.groupByField);
                String aggregateFieldName = aggregator.tupleDesc.getFieldName(aggregator.aggregateField);
                return new TupleDesc(new Type[]{aggregator.groupByFieldType, type},
                        new String[]{groupByFieldName, String.format("%s(%s)", aggregator.op, aggregateFieldName)});
            } else {
                // CASE NO GROUP
                Type type = Type.INT_TYPE;
                if (aggregator.op == Op.MAX || aggregator.op == Op.MIN) {
                    type = Type.STRING_TYPE;
                }
                String aggregateFieldName = aggregator.tupleDesc.getFieldName(aggregator.aggregateField);
                return new TupleDesc(new Type[]{type}, new String[]{String.format("%s(%s)", aggregator.op, aggregateFieldName)});
            }
        }
    }

}
