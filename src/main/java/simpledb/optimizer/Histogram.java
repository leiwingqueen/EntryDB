package simpledb.optimizer;

import simpledb.execution.Predicate;

// interface of histogram
// add by leiwingqueen 2023.02.06
public interface Histogram<T> {
    void addValue(T v);

    double estimateSelectivity(Predicate.Op op, T s);

    double avgSelectivity();
}
