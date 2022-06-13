package tms.servlet.service;

import tms.servlet.entity.Operation;
import tms.servlet.entity.User;
import tms.servlet.storage.DBOperationStorage;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CalculatorService {
    private final Operation saveOperation = new Operation();
    private final DBOperationStorage dbOperationStorage = new DBOperationStorage();

    public double calc(double num1, double num2, String operation, User currentUser) {
        double result = 0;
        switch (operation) {
            case "sum":
                result = num1 + num2;
                break;
            case "diff":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1 / num2;
                break;
        }
        saveOperation.setNum1(num1);
        saveOperation.setNum2(num2);
        saveOperation.setOperation(operation);
        saveOperation.setResult(result);
        saveOperation.setUser(currentUser);
        try {
            dbOperationStorage.save(saveOperation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
