package com.entry.db.transaction;

import com.entry.db.storage.PageId;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TransactionId is a class that contains the identifier of a transaction.
 */
public class TransactionId implements Serializable {

    private static final long serialVersionUID = 1L;

    static final AtomicLong counter = new AtomicLong(0);
    final long myid;

    // easy to find the related pages. used to unpin pages where the function is finished.
    // add by leiwingqueen
    private Set<PageId> pageSet;

    public TransactionId() {
        myid = counter.getAndIncrement();
        pageSet = new HashSet<>();
    }

    public long getId() {
        return myid;
    }

    public void addPage(PageId pid) {
        pageSet.add(pid);
    }

    public void removePage(PageId pid) {
        pageSet.remove(pid);
    }

    public Iterator<PageId> getPageIterator() {
        return pageSet.iterator();
    }

    public void clearPages() {
        pageSet.clear();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionId other = (TransactionId) obj;
        return myid == other.myid;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (myid ^ (myid >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "TransactionId{" +
                "myid=" + myid +
                '}';
    }
}
