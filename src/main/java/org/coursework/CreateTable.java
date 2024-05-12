package org.coursework;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTable {
    private Connection connection;
    private final String sql_query;

    Scanner scanner = new Scanner(System.in);

    public CreateTable(Connection connection) throws SQLException {
        this.sql_query = create_table();
        execute_query(connection);
    }

    private String create_table(){
        System.out.print("Enter SQL-query to create table: ");
        return scanner.nextLine();
    }
    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    private void execute_query(Connection connection) throws SQLException {
        System.out.println(this.sql_query);
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(this.sql_query);
        }catch (SQLException e){
            printSQLException(e);
        }
    }

}
