package org.coursework;

import org.coursework.execution.ExecuteQuery;
import org.coursework.execution.ExecuteQueryCreate;

import java.sql.Connection;
import java.util.Scanner;

public class CreateTable{
    private Connection connection;

    Scanner scanner = new Scanner(System.in);

    public CreateTable(Connection connection){
        String sql_query = create_table();
        ExecuteQuery executeQuery = new ExecuteQueryCreate();
        executeQuery.execute_query(connection, sql_query);
    }

    private String create_table(){
        System.out.print("Enter SQL-query to create table: ");
        return scanner.nextLine();
    }
//    private void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }

}
