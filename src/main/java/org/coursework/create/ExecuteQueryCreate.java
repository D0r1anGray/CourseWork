package org.coursework.create;

import org.coursework.database.ConnectionToDatabase;
import org.coursework.execution.ExecuteQuery;

import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryCreate extends ExecuteQuery {
    @Override
    public void execute_query(ConnectionToDatabase con, String sql_query){
        System.out.println(sql_query);
        try{
            Statement statement = con.getConnection().createStatement();
            statement.executeUpdate(sql_query);
        }catch (SQLException e){
            printSQLException(e);
        }
    }
}
