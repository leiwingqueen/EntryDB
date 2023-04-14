## TEST DATA

This directory contains test data

### Usage

create data files with the following command:

```shell
java -jar dist/simpledb.jar convert data/data.txt 2 "int,int"
java -jar dist/simpledb.jar convert data/some_data_file.txt 3
```
start parser with the following command:

```shell
java -jar dist/simpledb.jar parser data/catalog.txt
```