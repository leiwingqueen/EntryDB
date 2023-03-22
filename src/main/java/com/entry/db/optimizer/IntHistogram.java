package com.entry.db.optimizer;

import com.entry.db.execution.Predicate;

/**
 * A class to represent a fixed-width histogram over a single integer-based field.
 */
public class IntHistogram implements Histogram<Integer> {
    // bucket data. eg,[1,3,4,5] means that range [1,3),[3,4),[4,5),[5,+)
    private HistogramSlot[] buckets;
    private int size;
    private int min;
    private int max;
    private int bkSize;
    private int total;

    /**
     * Create a new IntHistogram.
     * <p>
     * This IntHistogram should maintain a histogram of integer values that it receives.
     * It should split the histogram into "buckets" buckets.
     * <p>
     * The values that are being histogrammed will be provided one-at-a-time through the "addValue()" function.
     * <p>
     * Your implementation should use space and have execution time that are both
     * constant with respect to the number of values being histogrammed.  For example, you shouldn't
     * simply store every value that you see in a sorted list.
     *
     * @param buckets The number of buckets to split the input value into.
     * @param min     The minimum integer value that will ever be passed to this class for histogramming
     * @param max     The maximum integer value that will ever be passed to this class for histogramming
     */
    public IntHistogram(int buckets, int min, int max) {
        // some code goes here
        if (buckets > max - min + 1) {
            buckets = max - min + 1;
        }
        this.size = buckets;
        this.buckets = new HistogramSlot[this.size];
        // the bucket size
        this.bkSize = (max - min + 1) / buckets;
        int start = min;
        for (int i = 0; i < size; i++) {
            int end = i != size - 1 ? start + bkSize : max + 1;
            this.buckets[i] = new HistogramSlot(start, end);
            start = end;
        }
        this.min = min;
        this.max = max;
        this.total = 0;
    }

    /**
     * Add a value to the set of values that you are keeping a histogram of.
     *
     * @param v Value to add to the histogram
     */
    @Override
    public void addValue(Integer v) {
        // some code goes here
        int idx = findIdx(v);
        buckets[idx].incr(1);
        total++;
    }

    /**
     * Estimate the selectivity of a particular predicate and operand on this table.
     * <p>
     * For example, if "op" is "GREATER_THAN" and "v" is 5,
     * return your estimate of the fraction of elements that are greater than 5.
     *
     * @param op Operator
     * @param v  Value
     * @return Predicted selectivity of this particular operator and value
     */
    @Override
    public double estimateSelectivity(Predicate.Op op, Integer v) {
        // some code goes here
        int cnt;
        switch (op) {
            case EQUALS:
                cnt = findEqual(v);
                return (double) cnt / total;
            case NOT_EQUALS:
                cnt = findEqual(v);
                return (double) (total - cnt) / total;
            case LESS_THAN:
                cnt = findLessThan(v);
                return (double) cnt / total;
            case LESS_THAN_OR_EQ:
                cnt = findLessThan(v + 1);
                return (double) cnt / total;
            case GREATER_THAN:
                cnt = findLessThan(v + 1);
                return (double) (total - cnt) / total;
            case GREATER_THAN_OR_EQ:
                cnt = findLessThan(v);
                return (double) (total - cnt) / total;
            default:
                return -1.0;
        }
    }

    private int findLessThan(int v) {
        if (v <= min) {
            return 0;
        }
        if (v > max) {
            return total;
        }
        int idx = findIdx(v);
        int sum = 0;
        for (int i = 0; i < idx; i++) {
            sum += buckets[i].value;
        }
        sum += buckets[idx].value * ((double) (v - buckets[idx].from) / (buckets[idx].to - buckets[idx].from));
        return sum;
    }

    private int findEqual(int v) {
        if (v < min || v > max) {
            return 0;
        }
        int idx = findIdx(v);
        return buckets[idx].value / (buckets[idx].to - buckets[idx].from);
    }

    private int findIdx(int v) {
        int dis = v - min + 1;
        int idx = dis / bkSize;
        if (idx >= size) {
            idx = size - 1;
        }
        return idx;
    }

    /**
     * @return the average selectivity of this histogram.
     * <p>
     * This is not an indispensable method to implement the basic
     * join optimization. It may be needed if you want to
     * implement a more efficient optimization
     */
    @Override
    public double avgSelectivity() {
        // some code goes here
        return this.total / (double) (max - min + 1);
    }

    /**
     * @return A string describing this histogram, for debugging purposes
     */
    public String toString() {
        // some code goes here
        //data format:
        // [start,end):count,...
        StringBuilder sb = new StringBuilder();
        int start = min;
        for (int i = 0; i < this.size; i++) {
            int end;
            if (i < size - 1) {
                end = start + this.bkSize;
            } else {
                end = max + 1;
            }
            sb.append(String.format("[%d,%d):%d,", start, end, buckets[i]));
        }
        return sb.toString();
    }

    private static class HistogramSlot {
        // [from,to)
        private int from;
        private int to;
        private int value;

        public HistogramSlot(int from, int to) {
            this.from = from;
            this.to = to;
            this.value = 0;
        }

        public void incr(int v) {
            this.value += v;
        }
    }
}
