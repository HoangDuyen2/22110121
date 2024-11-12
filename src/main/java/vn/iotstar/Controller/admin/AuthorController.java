//package vn.iotstar.Controller.admin;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import vn.iotstar.Entity.Author;
//import vn.iotstar.Service.IAuthorService;
//import vn.iotstar.Service.impl.AuthorServiceImpl;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/admin/authors","/admin/author-add","/admin/author-insert",
//        "/admin/author-upload","/admin/author-edit","/admin/author/delete"})
//public class AuthorController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    public IAuthorService authorService = new AuthorServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if(url.contains("/admin/authors")){
//            List<Author> list = authorService.findAll();
//            req.setAttribute("authors", list);
//            req.getRequestDispatcher("/views/admin/categoryList.jsp").forward(req, resp);
//        }
//        else if(url.contains("/admin/author-add")){
//            req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//        }
//        else if(url.contains("/admin/author-upload")){
//            int id = Integer.parseInt(req.getParameter("id"));
//            Author author = authorService.findById(id);
//            Date dateOfBirth = author.getDateOfBirth(); // Lấy dữ liệu từ CSDL
//            String formattedDate = null;
//
//            if (dateOfBirth != null) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                formattedDate = sdf.format(dateOfBirth); // Định dạng thành yyyy-MM-dd
//            }
//            req.setAttribute("formattedDate", formattedDate);
//            req.setAttribute("author", author);
//            req.getRequestDispatcher("/views/admin/editAuthor.jsp").forward(req, resp);
//        }
//        else{
//            int id = Integer.parseInt(req.getParameter("id"));  // Lấy ID từ request
//            Author author = authorService.findById(id);  // Lấy đối tượng Category dựa trên ID
//            // Sau khi xử lý xóa ảnh, xóa mục khỏi cơ sở dữ liệu
//            try {
//                authorService.deleteAuthor(author);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
////             Redirect sau khi xóa thành công
//            resp.sendRedirect(req.getContextPath() + "/admin/authors");
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if(url.contains("/admin/author-insert")){
//            String authorName = req.getParameter("authorName");
//            String dateOfBirthStr = req.getParameter("dateOfBirth"); // Nhận giá trị từ form
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateOfBirth = null;
//
//            try {
//                dateOfBirth = sdf.parse(dateOfBirthStr); // Chuyển đổi chuỗi sang Date
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            String alertMsg = "";
//
//            if (authorName.isEmpty()) {
//                alertMsg = "Please fill all fields";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//                return;
//            }
//
//            if(dateOfBirth.after(new Date())){
//                alertMsg = "Date of birth should be after now";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//            }
//
//            if (authorService.findAuthorByName(authorName) != null) {
//                alertMsg = "This name already exists";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//                return;
//            }
////            Dua du lieu vao model
//            Author author = new Author();
//            author.setAuthorName(authorName);
//            author.setDateOfBirth(dateOfBirth);
//
//            if (!authorService.insertAuthor(author)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//                return;
//            }
//            else {
//                resp.sendRedirect(req.getContextPath() + "/admin/authors");
//            }
//        }
//        if(url.contains("/admin/author-edit")){
//
//            String alertMsg = "";
//
//            int id = Integer.parseInt(req.getParameter("id"));
//            String authorName = req.getParameter("authorName");
//            String dateOfBirthStr = req.getParameter("dateOfBirth"); // Nhận giá trị từ form
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date dateOfBirth = null;
//
//            try {
//                dateOfBirth = sdf.parse(dateOfBirthStr); // Chuyển đổi chuỗi sang Date
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (authorName.isEmpty()) {
//                alertMsg = "Please fill all fields";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//                return;
//            }
//
//            if(dateOfBirth.after(new Date())){
//                alertMsg = "Date of birth should be after now";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
//            }
//
////            Dua du lieu vao model
//            Author author = authorService.findById(id);
//            Author author1 = authorService.findAuthorByName(authorName);
//
//            if (author1 != null ){
//                if (author1.getId() != author.getId()){
//                    alertMsg = "This name already exists";
//                    req.setAttribute("alertMsg", alertMsg);
//                    req.getRequestDispatcher("/admin/author-upload?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                }
//            }
//
//            author.setAuthorName(authorName);
//            author.setDateOfBirth(dateOfBirth);
//
//            if (!authorService.updateAuthor(author)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/admin/author-upload?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                return;
//            }
//            else {
//                resp.sendRedirect(req.getContextPath() + "/admin/authors");
//            }
//        }
//    }
//}
//
