package com.entry.db;

import com.entry.db.common.Database;
import com.entry.db.common.Type;
import com.entry.db.execution.SeqScan;
import com.entry.db.storage.HeapFile;
import com.entry.db.storage.Tuple;
import com.entry.db.storage.TupleDesc;
import com.entry.db.transaction.TransactionId;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

@Slf4j
public class Lab1Test {
    public static final String FILE_PATH = "src/resources/some_data_file.dat";

    public static void main(String[] argv) {

        // construct a 3-column table schema
        Type types[] = new Type[]{Type.INT_TYPE, Type.INT_TYPE, Type.INT_TYPE};
        String names[] = new String[]{"field0", "field1", "field2"};
        TupleDesc descriptor = new TupleDesc(types, names);

        // create the table, associate it with some_data_file.dat
        // and tell the catalog about the schema of this table.
        HeapFile table1 = new HeapFile(new File(FILE_PATH), descriptor);
        Database.getCatalog().addTable(table1, "test");

        // construct the query: we use a simple SeqScan, which spoonfeeds
        // tuples via its iterator.
        TransactionId tid = new TransactionId();
        SeqScan f = new SeqScan(tid, table1.getId());

        try {
            // and run it
            f.open();
            while (f.hasNext()) {
                Tuple tup = f.next();
                log.info("{}", tup);
            }
            f.close();
            Database.getBufferPool().transactionComplete(tid);
        } catch (Exception e) {
            log.error("Exception : " + e);
        }
    }
}
