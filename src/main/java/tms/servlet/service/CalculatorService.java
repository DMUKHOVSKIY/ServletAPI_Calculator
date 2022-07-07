package tms.servlet.service;

import tms.servlet.entity.Operation;
import tms.servlet.entity.User;
import tms.servlet.storage.DBOperationStorage;
import tms.servlet.storage.OperationStorage;


import java.sql.SQLException;


public class CalculatorService {
    private final OperationStorage operationStorage = DBOperationStorage.getInstance();
    private static volatile CalculatorService instance;

    private CalculatorService() {
    }

    public static CalculatorService getInstance() {
        synchronized (CalculatorService.class) {
            if (instance == null) {
                instance = new CalculatorService();
            }
            return instance;
        }
    }

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
        Operation saveOperation = new Operation.Builder()
                .num1(num1)
                .num2(num2)
                .operation(operation)
                .result(result)
                .user(currentUser)
                .build();
        try {
            operationStorage.save(saveOperation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
