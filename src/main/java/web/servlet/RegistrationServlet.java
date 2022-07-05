package web.servlet;

import tms.servlet.entity.User;
import tms.servlet.storage.DBUserStorage;
import tms.servlet.storage.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(urlPatterns = "/reg", name="RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserStorage userStorage = new DBUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUserName;

        try {
            byUserName = userStorage.findByUserName(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (byUserName.isPresent()) {
            req.setAttribute("message", "User with this username is already exists!");
            getServletContext().getRequestDispatcher("/reg.jsp").forward(req,resp);
        } else {
            User user = new User();
            user.setName(name);
            user.setUsername(username);
            user.setPassword(password);
            try {
                userStorage.save(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            resp.sendRedirect("/");

        }
    }
}
