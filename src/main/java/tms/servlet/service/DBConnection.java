package tms.servlet.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection connection() {
        try {
            connection = DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
