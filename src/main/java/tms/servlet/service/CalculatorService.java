package tms.servlet.service;

import tms.servlet.entity.User;

public interface CalculatorService {
    double calc(double num1, double num2, String operation, User currentUser);
}
