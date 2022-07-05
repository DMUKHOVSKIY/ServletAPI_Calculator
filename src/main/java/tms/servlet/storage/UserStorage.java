package tms.servlet.storage;

import tms.servlet.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserStorage {
    void save(User user) throws SQLException;

    Optional<User> findByUserName(String username) throws SQLException;
}
