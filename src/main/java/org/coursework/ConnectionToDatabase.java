package org.coursework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionToDatabase {
    private Connection connection;
    private final String db_url;
    private final String db_user;
    private final String db_password;

    Scanner scanner = new Scanner(System.in);

    public ConnectionToDatabase() {
        this.db_url = "jdbc:postgresql://localhost:5432/doriangray";
        this.db_user = enter_db_user();
        this.db_password = enter_db_password();
        this.connection = setConnection();
    }

    private String enter_db_url() {
        System.out.print("Enter database URL: ");
        return scanner.nextLine();
    }

    private String enter_db_user() {
        System.out.print("Enter database user: ");
        return scanner.nextLine();
    }
    private String enter_db_password() {
        System.out.print("Enter database password: ");
        return scanner.nextLine();
    }

    private Connection setConnection() {
        System.out.println("Database doriangray");
        try {
            connection = DriverManager.getConnection(this.db_url, this.db_user, this.db_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
