package tms.servlet.service;

import org.junit.Test;
import tms.servlet.entity.User;

import static org.junit.Assert.*;

public class CalculatorServiceImplTest {

    @Test
    public void calc() {
        CalculatorServiceImpl calculatorServiceImpl = CalculatorServiceImpl.getInstance();
        double calc = calculatorServiceImpl.calc(3, 4, "sum", new User.Builder().name("Tom").build());
        assertEquals(7.0,calc,0.0);
    }
}