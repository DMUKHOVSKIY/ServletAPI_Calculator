package web.servlet;

import tms.servlet.service.CalculatorService;
import tms.servlet.service.CalculatorServiceImpl;
import tms.servlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final CalculatorService calculatorService = CalculatorServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("result", calculatorService.calc(num1, num2, operation, currentUser));
        getServletContext().getRequestDispatcher("/calc.jsp").forward(req, resp);
    }
}
