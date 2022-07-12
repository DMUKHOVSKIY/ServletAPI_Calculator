package tms.servlet.dao;

import tms.servlet.entity.User;

import java.sql.*;
import java.util.Optional;

public class DBUserDao implements UserDao {
    private static volatile DBUserDao instance;

    private DBUserDao() {
    }

    public static DBUserDao getInstance() {
        synchronized (DBUserDao.class) {
            if (instance == null) {
                return new DBUserDao();
            }
            return instance;
        }
    }

    @Override
    public void save(User user) throws SQLException {
        PreparedStatement preparedStatement = DBConnectionFactory.connection().
                prepareStatement("insert into training15userstorage values (default, ?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.execute();
    }

    @Override
    public Optional<User> findByUserName(String username) throws SQLException {
        PreparedStatement preparedStatement = DBConnectionFactory.connection().
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
