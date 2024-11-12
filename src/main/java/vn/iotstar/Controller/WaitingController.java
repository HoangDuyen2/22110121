package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.Entity.Users;

import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("account") != null) {
            Users user = (Users) session.getAttribute("account");
            if (user.isAdmin()){
                resp.sendRedirect(req.getContextPath()+"/admin/home");
            }
            else {
                resp.sendRedirect(req.getContextPath()+"/user/home");
            }
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}
