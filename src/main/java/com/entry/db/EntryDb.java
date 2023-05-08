package com.entry.db;

import com.entry.db.common.DbException;
import com.entry.db.common.Type;
import com.entry.db.common.Utility;
import com.entry.db.index.BTreeFileEncoder;
import com.entry.db.storage.*;
import com.entry.db.transaction.TransactionAbortedException;
import com.entry.db.transaction.TransactionId;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class EntryDb {
    public static void main(String[] args)
            throws DbException, TransactionAbortedException {
        // convert a file
        switch (args[0]) {
            case "convert":
                try {
                    if (args.length < 3 || args.length > 5) {
                        // System.err.println("Unexpected number of arguments to convert ");
                        log.error("Unexpected number of arguments to convert ");
                        return;
                    }
                    File sourceTxtFile = new File(args[1]);
                    if (!sourceTxtFile.exists()) {
                        // load from resources
                        String file = EntryDb.class.getClassLoader().getResource(args[1]).getFile();
                        sourceTxtFile = new File(file);
                    }
                    File targetDatFile = new File(sourceTxtFile.getAbsolutePath().replaceAll(".txt", ".dat"));
                    int numOfAttributes = Integer.parseInt(args[2]);
                    Type[] ts = new Type[numOfAttributes];
                    char fieldSeparator = ',';

                    if (args.length == 3)
                        for (int i = 0; i < numOfAttributes; i++)
                            ts[i] = Type.INT_TYPE;
                    else {
                        String typeString = args[3];
                        String[] typeStringAr = typeString.split(",");
                        if (typeStringAr.length != numOfAttributes) {
                            // System.err.println("The number of types does not agree with the number of columns");
                            log.error("The number of types does not agree with the number of columns");
                            return;
                        }
                        int index = 0;
                        for (String s : typeStringAr) {
                            if (s.equalsIgnoreCase("int"))
                                ts[index++] = Type.INT_TYPE;
                            else if (s.equalsIgnoreCase("string"))
                                ts[index++] = Type.STRING_TYPE;
                            else {
                                // System.err.println("Unknown type " + s);
                                log.error("Unknown type " + s);
                                return;
                            }
                        }
                        if (args.length == 5)
                            fieldSeparator = args[4].charAt(0);
                    }
                    File hFile = new File(sourceTxtFile.getAbsolutePath().replaceAll(".txt", ".dat"));
                    File bTreeFile = new File(sourceTxtFile.getAbsolutePath().replaceAll(".txt", ".btree.dat"));
                    BTreeFileEncoder.convert(sourceTxtFile, hFile, bTreeFile, 0, numOfAttributes);
                    /*HeapFileEncoder.convert(sourceTxtFile, targetDatFile,
                            BufferPool.getPageSize(), numOfAttributes, ts, fieldSeparator);*/

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "print":
                File tableFile = new File(args[1]);
                int columns = Integer.parseInt(args[2]);
                DbFile table = Utility.openHeapFile(columns, tableFile);
                TransactionId tid = new TransactionId();
                DbFileIterator it = table.iterator(tid);

                if (null == it) {
                    log.info("Error: method HeapFile.iterator(TransactionId tid) not yet implemented!");
                    // System.out.println("Error: method HeapFile.iterator(TransactionId tid) not yet implemented!");
                } else {
                    it.open();
                    while (it.hasNext()) {
                        Tuple t = it.next();
                        System.out.println(t);
                    }
                    it.close();
                }
                break;
            case "parser":
                // Strip the first argument and call the parser
                String[] newargs = new String[args.length - 1];
                System.arraycopy(args, 1, newargs, 0, args.length - 1);

                try {
                    //dynamically load Parser -- if it doesn't exist, print error message
                    Class<?> c = Class.forName("com.entry.db.Parser");
                    Class<?> s = String[].class;

                    java.lang.reflect.Method m = c.getMethod("main", s);
                    m.invoke(null, (Object) newargs);
                } catch (ClassNotFoundException cne) {
                    // System.out.println("Class Parser not found -- perhaps you are trying to run the parser as a part of lab1?");
                    log.error("Class Parser not found -- perhaps you are trying to run the parser as a part of lab1?");
                } catch (Exception e) {
                    log.error("Error in parser.");
                    e.printStackTrace();
                }

                break;
            default:
                // System.err.println("Unknown command: " + args[0]);
                log.error("Unknown command: " + args[0]);
                System.exit(1);
        }
    }

}
