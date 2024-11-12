package vn.iotstar.Controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.Entity.Category;
import vn.iotstar.Entity.Video;
import vn.iotstar.Services.ICategoryService;
import vn.iotstar.Services.IVideoService;
import vn.iotstar.Services.impl.CategoryServiceImpl;
import vn.iotstar.Services.impl.VideoServiceImpl;
import vn.iotstar.Utils.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/categories","/admin/category-add","/admin/category-insert",
        "/admin/category-upload","/admin/category-edit","/admin/category/delete"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class CategoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin/categories")){
            List<Category> list = categoryService.findAll();
            req.setAttribute("categories", list);
            req.getRequestDispatcher("/views/admin/categoryList.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/category-add")){
            req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
        }
//        else if(url.contains("/admin/book-upload")){
//            int id = Integer.parseInt(req.getParameter("id"));
//            Video book = videoService.findById(id);
//            req.setAttribute("book", book);
//            req.getRequestDispatcher("/views/admin/editBook.jsp").forward(req, resp);
//        }
//        else {
//            int id = Integer.parseInt(req.getParameter("id"));  // Lấy ID từ request
//            Book book = bookService.findById(id);  // Lấy đối tượng Book dựa trên ID
//
//            // Xóa ảnh cũ
//            String uploadPath = req.getServletContext().getRealPath("") + File.separator + Constants.DIR;
//            String oldImagePath = uploadPath + File.separator + book.getCoverImage();
//            File oldImage = new File(oldImagePath);
//
//            try {
//                if (oldImage.exists()) {
//                    oldImage.delete();  // Xóa file ảnh cũ nếu tồn tại
//                }
//
//                // Xóa Book khỏi cơ sở dữ liệu
//                bookService.deleteBook(book);
//            } catch (Exception e) {
//                e.printStackTrace();
//                req.setAttribute("alertMsg", "Error deleting book or image.");
//                req.getRequestDispatcher("/views/admin/videoList.jsp").forward(req, resp);
//                return;
//            }
//
//            // Redirect sau khi xóa thành công
//            resp.sendRedirect(req.getContextPath() + "/admin/books");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        if(url.contains("/admin/category-insert")){
            String categoryName = req.getParameter("Categoryname");
            String categoryCode = req.getParameter("categorycode");

            String alertMsg = "";

            if (categoryCode.isEmpty()||categoryName.isEmpty()) {
                alertMsg = "Please fill all fields";
                req.setAttribute("alertMsg", alertMsg);
                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
                return;
            }

            if (categoryService.findByCategoryName(categoryName) != null) {
                alertMsg = "Category  exist";
                req.setAttribute("alertMsg", alertMsg);
                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
                return;
            }

            Category category = new Category();
            category.setCategoryname(categoryName);
            category.setCategorycode(categoryCode);
            category.setStatus(true);

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
                    category.setImages(image);
                }
                else {
                    category.setImages("./upload/demo_1.png");
                }
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }

//            Dua du lieu vao model

            if (!categoryService.insert(category)) {
                alertMsg = "Something went wrong";
                req.setAttribute("alertMsg", alertMsg);
                req.getRequestDispatcher("/views/admin/addCategory.jsp").forward(req, resp);
                return;
            }
            else {
                resp.sendRedirect(req.getContextPath() + "/admin/categories");
            }
        }
//        if(url.contains("/admin/book-edit")){
//
//            String alertMsg = "";
//
//            int id = Integer.parseInt(req.getParameter("id"));
//            String title = req.getParameter("title");
//            String author = req.getParameter("author");
//            String publisher = req.getParameter("publisher");
//            String description = req.getParameter("description");
//            int isbn = Integer.parseInt(req.getParameter("isbn"));
//            float price = Float.parseFloat(req.getParameter("price"));
//            int quantity = Integer.parseInt(req.getParameter("quantity"));
//            String publishDateStr = req.getParameter("publishDate"); // Nhận giá trị từ form
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date publishDate = null;
//
//            try {
//                publishDate = sdf.parse(publishDateStr); // Chuyển đổi chuỗi sang Date
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            Book book = bookService.findById(id);
//            String fileoId = book.getCoverImage();
//
//            String image = "";
//            String uploadPath = Constants.DIR;
//            File uploadDir = new File(uploadPath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//            try {
//                Part part = req.getPart("coverImage");
//                if (part.getSize() > 0){
//                    // Xóa ảnh cũ nếu tồn tại
//                    String oldImagePath = uploadPath + File.separator + book.getCoverImage();
//                    File oldImage = new File(oldImagePath);
//                    if (oldImage.exists())
//                    {
//                        oldImage.delete(); // Xóa ảnh cũ
//                    }
//                    String fileName = part.getSubmittedFileName();
//                    int index = fileName.lastIndexOf(".");
//                    String fileExtension = fileName.substring(index+1);
//                    image = System.currentTimeMillis()+"."+fileExtension;
//                    part.write(uploadPath + File.separator + image);
//                    book.setCoverImage(image);
//                }
//                else {
//                    book.setCoverImage(fileoId);
//                }
//            }catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            Author author1 = authorService.findAuthorByName(author);
//
//            book.setTitle(title);
//            book.setPublisher(publisher);
//            book.setDescription(description);
//            book.setIsbn(isbn);
//            book.setPrice(price);
//            book.setQuantity(quantity);
//            book.setPublishDate(publishDate);
//            book.getAuthorList().clear();
//            book.getAuthorList().add(author1);
//
//            if (!bookService.updateBook(book)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/admin/book-upload?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                return;
//            }
//            else {
//                resp.sendRedirect(req.getContextPath() + "/admin/books");
//            }
//        }
    }
}

