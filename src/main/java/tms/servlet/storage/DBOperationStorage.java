package tms.servlet.storage;


import tms.servlet.entity.Operation;
import tms.servlet.service.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBOperationStorage implements OperationStorage {

    private final UserStorage userStorage = DBUserStorage.getInstance();
    private static volatile DBOperationStorage instance;

    private DBOperationStorage() {
    }

    public static DBOperationStorage getInstance() {
        synchronized (DBOperationStorage.class) {
            if (instance == null) {
                return new DBOperationStorage();
            }
            return instance;
        }
    }

    @Override
    public void save(Operation operation) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.connection().
                prepareStatement("insert into training15operationstorage values (default,?,?,?,?,?,?)");
        preparedStatement.setDouble(1, operation.getNum1());
        preparedStatement.setDouble(2, operation.getNum2());
        preparedStatement.setString(3, operation.getOperation());
        preparedStatement.setString(4, operation.getUser().getUsername());
        preparedStatement.setDouble(5, operation.getResult());
        preparedStatement.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));

        preparedStatement.execute();
    }

    @Override
    public List<Operation> findAllOperationByUserName(String username) throws SQLException {
        PreparedStatement preparedStatement = DBConnection.connection().
                prepareStatement("select * from training15operationstorage where \"user\"=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Operation> operations = new ArrayList<>();
        while (resultSet.next()) {
            Operation operation = new Operation.Builder()
                    .id(resultSet.getInt(1))
                    .num1(resultSet.getDouble(2))
                    .num2(resultSet.getDouble(3))
                    .operation(resultSet.getString(4))
                    .user(userStorage.findByUserName(resultSet.getString(5)).get())
                    .result(resultSet.getDouble(6))
                    .date(resultSet.getDate(7))
                    .build();
            operations.add(operation);
        }

        return operations;

    }

}
