package tms.servlet.dao;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import tms.servlet.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.Assert.*;

public class DBUserDaoTest {

    private static User user;

    @BeforeClass
    public static void init() throws SQLException {
        user = new User.Builder().name("III").username("Tom").password("444").build();
        DBUserDao.getInstance().save(user);
    }

    @After
    public void eachFore() throws SQLException {
        PreparedStatement preparedStatement = DBConnectionFactory.connection()
                .prepareStatement("delete from training15userstorage where username = ?");
        preparedStatement.setString(1, "Tom");
        preparedStatement.execute();
    }

    @Test
    public void save() throws SQLException {
      Optional<User> user1 = DBUserDao.getInstance().findByUserName("Tom");
      assertEquals(user, user1.get());
    }

}