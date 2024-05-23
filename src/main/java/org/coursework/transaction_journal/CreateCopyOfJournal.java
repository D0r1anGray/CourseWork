package org.coursework.transaction_journal;

import org.coursework.database.ConnectionToDatabase;
import org.coursework.database.CreateCopyOfDatabase;
import org.coursework.execution.ExecuteAllBackup;
import org.coursework.execution.ExecuteJournalBackup;
import org.coursework.execution.ExecuteQuery;

public class CreateCopyOfJournal {
    public CreateCopyOfJournal(ConnectionToDatabase connection){
        String sql_query = "CALL backup_journal(?)";
        ExecuteQuery executeQuery = new ExecuteJournalBackup();
        executeQuery.execute_query(connection, sql_query);
    }

    public CreateCopyOfJournal(ConnectionToDatabase connection, String path){
        String sql_query = "CALL backup_journal('" + path + "')";
        ExecuteQuery executeQuery = new ExecuteJournalBackup();
        executeQuery.execute_query(connection, sql_query);
    }
}
