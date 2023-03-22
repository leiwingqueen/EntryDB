package com.entry.db.optimizer;

import com.entry.db.execution.Predicate;

// interface of histogram
// add by leiwingqueen 2023.02.06
public interface Histogram<T> {
    void addValue(T v);

    double estimateSelectivity(Predicate.Op op, T s);

    double avgSelectivity();
}
