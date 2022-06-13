package tms.servlet.storage;

import tms.servlet.entity.User;
import tms.servlet.service.DBConnection;

import java.sql.*;
import java.util.Optional;

public class DBUserStorage {

    private final DBConnection dbConnection = new DBConnection();

    public void save(User user) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.connection().
                prepareStatement("insert into training15userstorage values (default, ?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.execute();
    }

    public Optional<User> findByUserName(String username) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.connection().
                prepareStatement("select * from training15userstorage where username=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = new User();
        if (resultSet.next()) {
            user.setName(resultSet.getString(2));
            user.setUsername(resultSet.getString(3));
            if (user.getUsername() == null) {
                return Optional.empty();
            }
            user.setPassword(resultSet.getString(4));
        }

        return Optional.of(user);
    }


}
