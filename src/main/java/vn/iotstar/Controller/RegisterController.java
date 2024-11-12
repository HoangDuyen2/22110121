package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.Entity.Users;
import vn.iotstar.Services.IUserService;
import vn.iotstar.Services.impl.UserServiceImpl;
import vn.iotstar.Utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("re-password");
        String phone = req.getParameter("phone");
        String fullName = req.getParameter("fullname");
        String email = req.getParameter("email");

        Users user = new Users();

        String alertMsg = "";

        String image = "";
        String uploadPath = req.getServletContext().getRealPath("") + File.separator + Constants.DIR;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        try {
            Part part = req.getPart("images");
            if (part.getSize() > 0){
                String fileName = part.getSubmittedFileName();
                int index = fileName.lastIndexOf(".");
                String fileExtension = fileName.substring(index+1);
                image = System.currentTimeMillis()+"."+fileExtension;
                part.write(uploadPath + File.separator + image);
                user.setImages(image);
            }
            else {
                user.setImages("./upload/demo_1.png");
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(username.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()||phone.isEmpty()||fullName.isEmpty()) {
            alertMsg = "Please fill all fields";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
        }

        if (!password.equals(confirmPassword)) {
            alertMsg = "Passwords do not match";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        if (userService.findByUsername(username) != null) {
            alertMsg = "Username already exist";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }

        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setFullname(fullName);
        user.setEmail(email);
        user.setAdmin(false);
        user.setActive(true);
        if (!userService.insert(user)) {
            alertMsg = "Something went wrong";
            req.setAttribute("alertMsg", alertMsg);
            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
            return;
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
