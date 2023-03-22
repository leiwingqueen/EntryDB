package simpledb.transaction;

// https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/
public interface TxWaitForGraph {
    boolean addEdge(TransactionId from, TransactionId to);

    void removeEdge(TransactionId from, TransactionId to);

    boolean containsCircle();
}
