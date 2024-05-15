package org.coursework;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, let's try to connect to our database");
        ConnectionToDatabase connection = new ConnectionToDatabase();
        //CreateTable createTable = new CreateTable(connection.getConnection());
        SelectTable selectTable = new SelectTable(connection.getConnection());
    }
}