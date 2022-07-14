package tms.servlet.dao;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import tms.servlet.entity.Operation;
import tms.servlet.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DBOperationDaoTest {

    private static User user;

    @BeforeClass
    public static void init() throws SQLException {
        user = new User.Builder().name("III").username("Tom").password("444").build();
        DBUserDao.getInstance().save(user);
    }

    @After
    public void eachFor() throws SQLException {
        PreparedStatement preparedStatement =
                DBConnectionFactory.connection().
                prepareStatement("delete from training15operationstorage where \"user\"=?");
        preparedStatement.setString(1,"Tom");
        preparedStatement.execute();

    }

    @Test
    public void save() throws SQLException {
        OperationDao operationDao = DBOperationDao.getInstance();
        Operation build = new Operation.Builder().num1(3).num2(2).operation("sum").result(5).user(user).build();
        operationDao.save(build);

        List<Operation> tom;
        tom = operationDao.findAllOperationByUserName("Tom");
        assertEquals(build, tom.get(0));
    }

    @Test
    public void findAllOperationByUserName() throws SQLException {
        OperationDao operationDao = DBOperationDao.getInstance();

        Operation op0 = new Operation.Builder().num1(4).num2(2).operation("sum").result(6).user(user).build();
        Operation op1 = new Operation.Builder().num1(4).num2(5).operation("sum").result(9).user(user).build();
        Operation op2 = new Operation.Builder().num1(5).num2(4).operation("diff").result(1).user(user).build();
        Operation op3 = new Operation.Builder().num1(1).num2(4).operation("mul").result(4).user(user).build();
        Operation op4 = new Operation.Builder().num1(9).num2(3).operation("div").result(3).user(user).build();
        Operation op5 = new Operation.Builder().num1(10).num2(2).operation("sum").result(12).user(user).build();

        List<Operation> list = new ArrayList();
        list.add(op0);
        list.add(op1);
        list.add(op2);
        list.add(op3);
        list.add(op4);
        list.add(op5);

        operationDao.save(op0);
        operationDao.save(op1);
        operationDao.save(op2);
        operationDao.save(op3);
        operationDao.save(op4);
        operationDao.save(op5);

        List<Operation> tom = operationDao.findAllOperationByUserName("Tom");

        assertEquals(list, tom);
    }
}