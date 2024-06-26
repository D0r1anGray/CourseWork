package org.coursework.execution;

import org.coursework.database.ConnectionToDatabase;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteAllBackup extends ExecuteQuery{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute_query(ConnectionToDatabase con, String sql_query){
        System.out.println(sql_query);
        try {
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql_query);
            //System.out.print("Enter a path to save copy: ");
//            preparedStatement.setString(1,scanner.nextLine());
//            //System.out.print("Enter a name of copy: ");
//            preparedStatement.setString(2,scanner.nextLine());
            preparedStatement.setString(1, con.get_db_user());
            preparedStatement.setString(2, con.get_db_name());
            preparedStatement.execute();
        }
        catch (SQLException e){
            printSQLException(e);
        }
    }
}
