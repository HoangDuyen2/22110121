package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.Entity.Users;
import vn.iotstar.Services.IUserService;
import vn.iotstar.Services.impl.UserServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String alertMsg = "";
        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Email or password cannot be empty";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }

        Users user = userService.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", user);
            Cookie cookie = new Cookie("account", user.getUsername());
            cookie.setMaxAge(24 * 60 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/waiting");
        }
        else {
            alertMsg = "Invalid email or password";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
}
