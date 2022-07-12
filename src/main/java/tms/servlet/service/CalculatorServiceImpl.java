package tms.servlet.service;

import tms.servlet.entity.Operation;
import tms.servlet.entity.User;
import tms.servlet.dao.DBOperationDao;
import tms.servlet.dao.OperationDao;


import java.sql.SQLException;


public class CalculatorServiceImpl implements CalculatorService{
    private final OperationDao operationDao = DBOperationDao.getInstance();
    private static volatile CalculatorServiceImpl instance;

    private CalculatorServiceImpl() {
    }

    public static CalculatorServiceImpl getInstance() {
        synchronized (CalculatorServiceImpl.class) {
            if (instance == null) {
                instance = new CalculatorServiceImpl();
            }
            return instance;
        }
    }

    @Override
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
            operationDao.save(saveOperation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
