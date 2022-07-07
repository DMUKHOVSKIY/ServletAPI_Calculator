package tms.servlet.storage;

import tms.servlet.entity.User;
import tms.servlet.service.DBConnection;

import java.sql.*;
import java.util.Optional;

public class DBUserStorage implements UserStorage {
    private static volatile DBUserStorage instance;

    private DBUserStorage() {
    }

    public static DBUserStorage getInstance() {
        synchronized (DBUserStorage.class) {
            if (instance == null) {
                return new DBUserStorage();
            }
            return instance;
        }
    }

    @Override
    public void save(User user) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.connection().
                prepareStatement("insert into training15userstorage values (default, ?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.execute();
    }

    @Override
    public Optional<User> findByUserName(String username) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.connection().
                prepareStatement("select * from training15userstorage where username=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User.Builder()
                    .name(resultSet.getString(2))
                    .username(resultSet.getString(3))
                    .password(resultSet.getString(4))
                    .build();
            return Optional.of(user);
        }

        return Optional.empty();
    }


}
