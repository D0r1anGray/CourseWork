package org.coursework.execution;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryCreate extends ExecuteQuery{
    @Override
    public void execute_query(Connection connection, String sql_query){
        System.out.println(sql_query);
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql_query);
        }catch (SQLException e){
            printSQLException(e);
        }
    }
}
