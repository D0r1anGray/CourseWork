package org.coursework;

import org.coursework.execution.ExecuteQuery;
import org.coursework.execution.ExecuteQuerySelect;

import java.sql.Connection;
import java.util.Scanner;

public class SelectTable {

    Scanner scanner = new Scanner(System.in);
    public SelectTable(Connection connection){
        String sql_query = select_all_table();
        ExecuteQuery executeQuery = new ExecuteQuerySelect();
        executeQuery.execute_query(connection, sql_query);
    }

    private String select_all_table(){
        System.out.print("Enter SQL-query to select all from table: ");
        return scanner.nextLine();
    }
}
