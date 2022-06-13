package tms.servlet.storage;


import tms.servlet.entity.Operation;
import tms.servlet.service.DBConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DBOperationStorage {

    private final DBUserStorage dbUserStorage = new DBUserStorage();
    private final DBConnection dbConnection = new DBConnection();

    public void save(Operation operation) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.connection().
                prepareStatement("insert into training15operationstorage values (default,?,?,?,?,?,?)");
        preparedStatement.setDouble(1, operation.getNum1());
        preparedStatement.setDouble(2, operation.getNum2());
        preparedStatement.setString(3, operation.getOperation());
        preparedStatement.setString(4, operation.getUser().getUsername());
        preparedStatement.setDouble(5, operation.getResult());
        preparedStatement.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));

        preparedStatement.execute();
    }

    public List<Operation> findAllOperationByUserName(String username) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.connection().
                prepareStatement("select * from training15operationstorage where \"user\"=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Operation> operations = new ArrayList<>();
        while (resultSet.next()) {
            Operation operation = new Operation();
            operation.setId(resultSet.getInt(1));
            operation.setNum1(resultSet.getDouble(2));
            operation.setNum2(resultSet.getDouble(3));
            operation.setOperation(resultSet.getString(4));
            operation.setUser(dbUserStorage.findByUserName(resultSet.getString(5)).get());
            operation.setResult(resultSet.getDouble(6));
            operation.setDate(resultSet.getDate(7));
            operations.add(operation);
        }

        return operations;

    }

}
