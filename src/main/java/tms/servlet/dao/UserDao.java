package tms.servlet.dao;

import tms.servlet.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao {
    void save(User user) throws SQLException;

    Optional<User> findByUserName(String username) throws SQLException;
}
