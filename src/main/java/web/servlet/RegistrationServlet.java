package web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tms.servlet.entity.User;
import tms.servlet.dao.DBUserDao;
import tms.servlet.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserDao userDao = DBUserDao.getInstance();
    private Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

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
            byUserName = userDao.findByUserName(username);
        } catch (SQLException e) {
            logger.error("Error", e);
            throw new RuntimeException(e);
        }

        if (byUserName.isPresent()) {
            req.setAttribute("message", "User with this username is already exists!");
            getServletContext().getRequestDispatcher("/reg.jsp").forward(req, resp);
        } else {
            User user = new User.Builder()
                    .name(name)
                    .username(username)
                    .password(password)
                    .build();
            try {
                userDao.save(user);
                logger.info("Saving a user");
            } catch (SQLException e) {
                logger.error("Error", e);
                throw new RuntimeException(e);
            }

            resp.sendRedirect("/");

        }
    }
}
