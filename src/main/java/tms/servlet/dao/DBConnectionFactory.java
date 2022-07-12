package tms.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection connection() {
        try {
            return DriverManager.
                    getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
