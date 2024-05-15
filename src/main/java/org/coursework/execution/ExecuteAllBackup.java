package org.coursework.execution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteAllBackup extends ExecuteQuery{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute_query(Connection connection, String sql_query){
        System.out.println(sql_query);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql_query);
            System.out.print("Enter a path to save copy of database: ");
            preparedStatement.setString(1,scanner.nextLine());
            System.out.print("Enter a name of copy of database: ");
            preparedStatement.setString(2,scanner.nextLine());
            preparedStatement.execute();
        }
        catch (SQLException e){
            printSQLException(e);
        }
    }
}
