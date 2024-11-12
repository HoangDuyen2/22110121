//package vn.iotstar.Controller;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import vn.iotstar.Entity.User;
//import vn.iotstar.Service.IUserService;
//import vn.iotstar.Service.impl.UserServiceImpl;
//
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/forgot-password")
//public class ForgotPasswordController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    IUserService userService = new UserServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String repeatPassword = req.getParameter("re-password");
//
//        String alertMsg = "";
//
//        if(!userService.findByEmail(email)){
//            alertMsg = "Email does not exist";
//            req.setAttribute("alertMsg", alertMsg);
//            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
//        }
//        if(!password.equals(repeatPassword)){
//            alertMsg = "Passwords do not match";
//            req.setAttribute("alertMsg", alertMsg);
//            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
//        }
//        User user = userService.findUserByEmail(email);
//        user.setPassword(password);
//        if (!userService.updateUser(user)){
//            alertMsg = "User does not exist";
//            req.setAttribute("alertMsg", alertMsg);
//            req.getRequestDispatcher("/views/forgot-password.jsp").forward(req, resp);
//        }
//        else {
//            resp.sendRedirect(req.getContextPath()+"/login");
//        }
//    }
//}
