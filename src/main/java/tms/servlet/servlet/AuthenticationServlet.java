package tms.servlet.servlet;

import tms.servlet.entity.User;
import tms.servlet.storage.DBUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(urlPatterns = "/auth")
public class AuthenticationServlet extends HttpServlet {

    private final DBUserStorage dbUserStorage = new DBUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> byUserName = null;

        try {
            byUserName = dbUserStorage.findByUserName(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (byUserName.isPresent()) {
            User user = byUserName.get();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect("/");
            } else {
                req.setAttribute("message", "Wrong password!");
                getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);

            }
        } else {
            req.setAttribute("message", "User not found!");
            getServletContext().getRequestDispatcher("/auth.jsp").forward(req, resp);
        }


    }
}
