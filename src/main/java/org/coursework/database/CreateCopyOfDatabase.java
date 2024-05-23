package org.coursework.database;

import org.coursework.database.ConnectionToDatabase;
import org.coursework.execution.ExecuteAllBackup;
import org.coursework.execution.ExecuteQuery;

import java.sql.SQLException;

public class CreateCopyOfDatabase{
//    Scanner scanner = new Scanner(System.in);

//    public CreateCopyOfDatabase(Connection connection) throws SQLException {
//        String sql_query = "CALL backup_database(?, ?, ?, ?);";
//        ExecuteQuery executeQuery = new ExecuteAllBackup();
//        executeQuery.execute_query(connection, sql_query);
//    }

    public CreateCopyOfDatabase(ConnectionToDatabase connection) throws SQLException {
        String sql_query = "CALL backup_database(?, ?, ?, ?);";
        ExecuteQuery executeQuery = new ExecuteAllBackup();
        executeQuery.execute_query(connection, sql_query);
    }

    public CreateCopyOfDatabase(ConnectionToDatabase connection, String db_name, String path){
        String sql_query = "CALL backup_database('" + path + "','" +db_name+"', ?, ?)";
        ExecuteQuery executeQuery = new ExecuteAllBackup();
        executeQuery.execute_query(connection, sql_query);
    }

}
