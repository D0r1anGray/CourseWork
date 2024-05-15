package org.coursework;

import org.coursework.execution.ExecuteAllBackup;
import org.coursework.execution.ExecuteQuery;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateCopyOfDatabase{
//    Scanner scanner = new Scanner(System.in);

    public CreateCopyOfDatabase(Connection connection) throws SQLException {
        String sql_query = "CALL backup_database(?, ?);";
        ExecuteQuery executeQuery = new ExecuteAllBackup();
        executeQuery.execute_query(connection, sql_query);
    }

}
