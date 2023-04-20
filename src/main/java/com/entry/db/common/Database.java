package com.entry.db.common;

import com.entry.db.index.BTreeLatchManager;
import com.entry.db.storage.BufferPool;
import com.entry.db.storage.LogFile;
import com.entry.db.transaction.LockManager;
import com.entry.db.transaction.SimpleLockManager;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Database is a class that initializes several static variables used by the
 * database system (the catalog, the buffer pool, and the log files, in
 * particular.)
 * <p>
 * Provides a set of methods that can be used to access these variables from
 * anywhere.
 *
 * @Threadsafe
 */
@Slf4j
public class Database {
    private static final AtomicReference<Database> _instance = new AtomicReference<>(new Database());
    private final Catalog _catalog;
    private final BufferPool _bufferpool;

    private final static String LOGFILENAME = "work/wal/log";
    private final LogFile _logfile;
    private BTreeLatchManager _bTreeLatchManager;
    private LockManager _lockManager;

    private Database() {
        _catalog = new Catalog();
        _bufferpool = new BufferPool(BufferPool.DEFAULT_PAGES);
        LogFile tmp = null;
        try {
            tmp = new LogFile(new File(LOGFILENAME));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        _logfile = tmp;
        _bTreeLatchManager = new BTreeLatchManager();
        _lockManager = new SimpleLockManager();
        // startControllerThread();
    }

    /**
     * Return the log file of the static Database instance
     */
    public static LogFile getLogFile() {
        return _instance.get()._logfile;
    }

    /**
     * Return the buffer pool of the static Database instance
     */
    public static BufferPool getBufferPool() {
        return _instance.get()._bufferpool;
    }

    /**
     * Return the catalog of the static Database instance
     */
    public static Catalog getCatalog() {
        return _instance.get()._catalog;
    }

    public static BTreeLatchManager getBTreeLatchManager() {
        return _instance.get()._bTreeLatchManager;
    }

    public static LockManager getLockManager() {
        return _instance.get()._lockManager;
    }

    /**
     * Method used for testing -- create a new instance of the buffer pool and
     * return it
     */
    public static BufferPool resetBufferPool(int pages) {
        java.lang.reflect.Field bufferPoolF = null;
        try {
            bufferPoolF = Database.class.getDeclaredField("_bufferpool");
            bufferPoolF.setAccessible(true);
            bufferPoolF.set(_instance.get(), new BufferPool(pages));
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            e.printStackTrace();
        }
        resetLogManager();
        //        _instance._bufferpool = new BufferPool(pages);
        return _instance.get()._bufferpool;
    }

    private static void resetLogManager() {
        _instance.get()._lockManager = new SimpleLockManager();
        _instance.get()._bTreeLatchManager = new BTreeLatchManager();
    }

    // reset the database, used for unit tests only.
    public static void reset() {
        _instance.set(new Database());
    }

}
