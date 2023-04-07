package com.entry.db.common;

import com.entry.db.storage.DbFile;
import com.entry.db.storage.HeapFile;
import com.entry.db.storage.TupleDesc;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The Catalog keeps track of all available tables in the database and their
 * associated schemas.
 * For now, this is a stub catalog that must be populated with tables by a
 * user program before it can be used -- eventually, this should be converted
 * to a catalog that reads a catalog table from disk.
 *
 * @Threadsafe
 */
@Slf4j
public class Catalog {
    // <tableId,TableInf>
    private Map<Integer, TableInf> tableInfMap;
    // <name,tableId>. the index use to find the tableId by tableName
    private Map<String, Integer> name2IdMap;

    /**
     * Constructor.
     * Creates a new, empty catalog.
     */
    public Catalog() {
        // some code goes here
        this.tableInfMap = new ConcurrentHashMap<>();
        this.name2IdMap = new ConcurrentHashMap<>();
    }

    /**
     * Add a new table to the catalog.
     * This table's contents are stored in the specified DbFile.
     *
     * @param file      the contents of the table to add;  file.getId() is the identfier of
     *                  this file/tupledesc param for the calls getTupleDesc and getFile
     * @param name      the name of the table -- may be an empty string.  May not be null.  If a name
     *                  conflict exists, use the last table to be added as the table for a given name.
     * @param pkeyField the name of the primary key field
     */
    public void addTable(DbFile file, String name, String pkeyField) {
        // some code goes here
        TableInf tableIn = new TableInf(file, name, pkeyField);
        // handle duplicate table
        if (tableInfMap.containsKey(file.getId())) {
            TableInf tableInf = tableInfMap.get(file.getId());
            tableInfMap.remove(file.getId());
            name2IdMap.remove(tableInf.getName());
        }
        // what if table name already exist
        if (name2IdMap.containsKey(name)) {
            int rmTableId = name2IdMap.get(name);
            tableInfMap.remove(rmTableId);
            name2IdMap.remove(name);
        }
        this.tableInfMap.put(file.getId(), tableIn);
        this.name2IdMap.put(name, file.getId());
    }

    public void addTable(DbFile file, String name) {
        addTable(file, name, "");
    }

    /**
     * Add a new table to the catalog.
     * This table has tuples formatted using the specified TupleDesc and its
     * contents are stored in the specified DbFile.
     *
     * @param file the contents of the table to add;  file.getId() is the identfier of
     *             this file/tupledesc param for the calls getTupleDesc and getFile
     */
    public void addTable(DbFile file) {
        addTable(file, (UUID.randomUUID()).toString());
    }

    /**
     * Return the id of the table with a specified name,
     *
     * @throws NoSuchElementException if the table doesn't exist
     */
    public int getTableId(String name) throws NoSuchElementException {
        // some code goes here
        if (name == null || !name2IdMap.containsKey(name)) {
            throw new NoSuchElementException("table name not exist");
        }
        return name2IdMap.get(name);
    }

    /**
     * Returns the tuple descriptor (schema) of the specified table
     *
     * @param tableid The id of the table, as specified by the DbFile.getId()
     *                function passed to addTable
     * @throws NoSuchElementException if the table doesn't exist
     */
    public TupleDesc getTupleDesc(int tableid) throws NoSuchElementException {
        // some code goes here
        if (!tableInfMap.containsKey(tableid)) {
            throw new NoSuchElementException("table id not exist");
        }
        return tableInfMap.get(tableid).getFile().getTupleDesc();
    }

    /**
     * Returns the DbFile that can be used to read the contents of the
     * specified table.
     *
     * @param tableid The id of the table, as specified by the DbFile.getId()
     *                function passed to addTable
     */
    public DbFile getDatabaseFile(int tableid) throws NoSuchElementException {
        // some code goes here
        if (!tableInfMap.containsKey(tableid)) {
            throw new NoSuchElementException("table id not exist");
        }
        return tableInfMap.get(tableid).getFile();
    }

    public String getPrimaryKey(int tableid) {
        // some code goes here
        return null;
    }

    public Iterator<Integer> tableIdIterator() {
        // some code goes here
        return tableInfMap.keySet().iterator();
    }

    public String getTableName(int id) {
        // some code goes here
        return tableInfMap.get(id).getName();
    }

    /**
     * Delete all tables from the catalog
     */
    public void clear() {
        // some code goes here
        tableInfMap.clear();
        name2IdMap.clear();
    }

    /**
     * Reads the schema from a file and creates the appropriate tables in the database.
     *
     * @param catalogFile
     */
    public void loadSchema(String catalogFile) {
        String line = "";
        String baseFolder = new File(new File(catalogFile).getAbsolutePath()).getParent();
        try {
            BufferedReader br = new BufferedReader(new FileReader(catalogFile));

            while ((line = br.readLine()) != null) {
                //assume line is of the format name (field type, field type, ...)
                String name = line.substring(0, line.indexOf("(")).trim();
                //System.out.println("TABLE NAME: " + name);
                String fields = line.substring(line.indexOf("(") + 1, line.indexOf(")")).trim();
                String[] els = fields.split(",");
                List<String> names = new ArrayList<>();
                List<Type> types = new ArrayList<>();
                String primaryKey = "";
                for (String e : els) {
                    String[] els2 = e.trim().split(" ");
                    names.add(els2[0].trim());
                    if (els2[1].trim().equalsIgnoreCase("int"))
                        types.add(Type.INT_TYPE);
                    else if (els2[1].trim().equalsIgnoreCase("string"))
                        types.add(Type.STRING_TYPE);
                    else {
                        System.out.println("Unknown type " + els2[1]);
                        System.exit(0);
                    }
                    if (els2.length == 3) {
                        if (els2[2].trim().equals("pk"))
                            primaryKey = els2[0].trim();
                        else {
                            System.out.println("Unknown annotation " + els2[2]);
                            System.exit(0);
                        }
                    }
                }
                Type[] typeAr = types.toArray(new Type[0]);
                String[] namesAr = names.toArray(new String[0]);
                TupleDesc t = new TupleDesc(typeAr, namesAr);
                HeapFile tabHf = new HeapFile(new File(baseFolder + "/" + name + ".dat"), t);
                addTable(tabHf, name, primaryKey);
                log.info("Added table : " + name + " with schema " + t);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IndexOutOfBoundsException e) {
            log.error("Error parsing line: " + line);
            System.exit(0);
        }
    }

    // table information
    // add by leiwingqueen
    private static class TableInf {
        private DbFile file;
        private String name;
        private String pkeyField;

        public TableInf(DbFile file, String name, String pkeyField) {
            this.file = file;
            this.name = name;
            this.pkeyField = pkeyField;
        }

        public DbFile getFile() {
            return file;
        }

        public String getName() {
            return name;
        }

        public String getPkeyField() {
            return pkeyField;
        }
    }
}

