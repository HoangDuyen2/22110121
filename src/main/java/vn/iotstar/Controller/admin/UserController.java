//package vn.iotstar.Controller.admin;
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
//import java.sql.Date;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/admin/users","/admin/user-add","/admin/user-insert",
//        "/admin/user-upload","/admin/user-edit","/admin/user/delete"})
//public class UserController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    public IUserService userService = new UserServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if(url.contains("/admin/users")){
//            List<User> list = userService.findAll();
//            req.setAttribute("users", list);
//            req.getRequestDispatcher("/views/admin/userList.jsp").forward(req, resp);
//        }
//        else if(url.contains("/admin/user-add")){
//            req.getRequestDispatcher("/views/admin/addUser.jsp").forward(req, resp);
//        }
//        else if(url.contains("/admin/user-upload")){
//            int id = Integer.parseInt(req.getParameter("id"));
//            User user = userService.findById(id);
//            req.setAttribute("user", user);
//            req.getRequestDispatcher("/views/admin/editUser.jsp").forward(req, resp);
//        }
//        else{
//            int id = Integer.parseInt(req.getParameter("id"));  // Lấy ID từ request
//            User user = userService.findById(id);  // Lấy đối tượng Category dựa trên ID
//            // Sau khi xử lý xóa ảnh, xóa mục khỏi cơ sở dữ liệu
//            try {
//                userService.deleteUser(user);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
////             Redirect sau khi xóa thành công
//            resp.sendRedirect(req.getContextPath() + "/admin/users");
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if(url.contains("/admin/user-insert")){
//            String fullName = req.getParameter("fullName");
//            String email = req.getParameter("email");
//            String phone = req.getParameter("phone");
//
//            String alertMsg = "";
//
//            if (fullName.isEmpty()||email.isEmpty()||phone.isEmpty()) {
//                alertMsg = "Please fill all fields";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addUser.jsp").forward(req, resp);
//                return;
//            }
//
//            if (userService.findByEmail(email)){
//                alertMsg = "Email already exist";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addUser.jsp").forward(req, resp);
//                return;
//            }
//            if (userService.findByPhone(phone)){
//                alertMsg = "Phone already exist";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addUser.jsp").forward(req, resp);
//                return;
//            }
////            Dua du lieu vao model
//            User user = new User();
//            user.setFullName(fullName);
//            user.setEmail(email);
//            user.setPhone(phone);
//            user.setAdmin(false);
//            user.setSignupDate(new Date(System.currentTimeMillis()).toLocalDate());
//            user.setPassword("123456");
//
//            if (!userService.insertUser(user)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addUser.jsp").forward(req, resp);
//                return;
//            }
//            else {
//                resp.sendRedirect(req.getContextPath() + "/admin/users");
//            }
//        }
//        if(url.contains("/admin/user-edit")){
//
//            String alertMsg = "";
//
//            int id = Integer.parseInt(req.getParameter("id"));
//            String fullName = req.getParameter("fullName");
//            String email = req.getParameter("email");
//            String phone = req.getParameter("phone");
////            Dua du lieu vao model
//            User user = userService.findById(id);
//            User user1 = userService.findUserByEmail(email);
//            User user2 = userService.findUserByPhone(phone);
//
//            if (user1 != null ){
//                if (user1.getId() != user.getId()){
//                    alertMsg = "Email already exist";
//                    req.setAttribute("alertMsg", alertMsg);
//                    req.getRequestDispatcher("/admin/user-upload?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                }
//            }
//
//            if(user2 != null){
//                if (user2.getId() != user.getId()){
//                    alertMsg = "Phone already exist";
//                    req.setAttribute("alertMsg", alertMsg);
//                    req.getRequestDispatcher("/admin/user-upload?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                }
//            }
//
//            user.setFullName(fullName);
//            user.setEmail(email);
//            user.setPhone(phone);
//
//            if (!userService.updateUser(user)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/admin/user-upload?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                return;
//            }
//            else {
//                resp.sendRedirect(req.getContextPath() + "/admin/users");
//            }
//        }
//    }
//}
