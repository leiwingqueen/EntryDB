package com.entry.db;

import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

public class CalciteSqlExample {
    public static void main(String[] args) {
        // 定义一个 SQL 查询
        String sql = "SELECT id, name, age FROM users WHERE age > 20";

        // 使用 Calcite 解析 SQL 查询
        SqlParser.Config config = SqlParser.configBuilder().setCaseSensitive(false).build();
        SqlParser sqlParser = SqlParser.create(sql, config);

        try {
            SqlNode sqlNode = sqlParser.parseQuery();
            System.out.println("Parsed SQL: " + sqlNode.toString());

            // 处理 SELECT 语句
            if (sqlNode instanceof SqlSelect) {
                SqlSelect sqlSelect = (SqlSelect) sqlNode;

                // 获取字段列表
                SqlNodeList fieldList = sqlSelect.getSelectList();
                System.out.println("Fields:");
                for (SqlNode field : fieldList) {
                    System.out.println("  - " + field.toString());
                }

                // 获取表名
                SqlIdentifier tableName = (SqlIdentifier) sqlSelect.getFrom();
                System.out.println("Table: " + tableName.getSimple());
            }

        } catch (SqlParseException e) {
            System.err.println("Error parsing SQL: " + e.getMessage());
        }
    }
}

