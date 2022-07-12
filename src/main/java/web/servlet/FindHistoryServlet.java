package web.servlet;

import tms.servlet.entity.Operation;
import tms.servlet.entity.User;
import tms.servlet.dao.DBOperationDao;
import tms.servlet.dao.OperationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(urlPatterns = "/findHistory", name = "FindHistoryServlet")
public class FindHistoryServlet extends HttpServlet {

    private final OperationDao operationDao = DBOperationDao.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("currentUser");
        List<Operation> allOperationByUsername;
        try {
              allOperationByUsername = operationDao.findAllOperationByUserName(currentUser.getUsername());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("operations", allOperationByUsername);
            getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);

    }
}
