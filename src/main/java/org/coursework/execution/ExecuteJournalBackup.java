package org.coursework.execution;

import org.coursework.database.ConnectionToDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteJournalBackup extends ExecuteQuery{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute_query(ConnectionToDatabase con, String sql_query){
        System.out.println(sql_query);
        try {
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql_query);
            //System.out.print("Enter a path to save copy: ");
//            preparedStatement.setString(1,scanner.nextLine());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            printSQLException(e);
        }
    }
}
