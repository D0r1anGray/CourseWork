package org.coursework;

import org.coursework.database.ConnectionToDatabase;
import org.coursework.database.CreateCopyOfDatabase;
import org.coursework.transaction_journal.CreateCopyOfJournal;
import org.coursework.window.Visual1;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, let's try to connect to our database");
//        ConnectionToDatabase connection = new ConnectionToDatabase();
//        //CreateTable createTable = new CreateTable(connection.getConnection());
//        //SelectTable selectTable = new SelectTable(connection.getConnection());
//        //CreateCopyOfDatabase createCopyOfDatabase = new CreateCopyOfDatabase(connection);
//        CreateCopyOfJournal createCopyOfJournal = new CreateCopyOfJournal(connection);
        EventQueue.invokeLater(() -> {
            Visual1 ex = new Visual1();
            ex.setVisible(true);
        });
    }
}