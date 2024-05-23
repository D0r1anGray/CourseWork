package org.coursework.execution;

import org.coursework.database.ConnectionToDatabase;

import java.sql.SQLException;

public abstract class ExecuteQuery {
    protected void printSQLException(SQLException ex){
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
    public void execute_query(ConnectionToDatabase con, String sql_query){
//        System.out.println(sql_query);
//        try{
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(sql_query);
//        }catch (SQLException e){
//            printSQLException(e);
//        }
    }
}
