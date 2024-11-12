//package vn.iotstar.Controller.admin;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.Part;
//import vn.iotstar.Entity.Author;
//import vn.iotstar.Entity.Book;
//import vn.iotstar.Service.IAuthorService;
//import vn.iotstar.Service.IBookService;
//import vn.iotstar.Service.impl.AuthorServiceImpl;
//import vn.iotstar.Service.impl.BookServiceImpl;
//import vn.iotstar.Utils.Constants;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/admin/books","/admin/book-add","/admin/book-insert",
//        "/admin/book-upload","/admin/book-edit","/admin/book/delete"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
//        maxFileSize = 1024 * 1024 * 10,      // 10 MB
//        maxRequestSize = 1024 * 1024 * 100   // 100 MB
//)
//public class BookController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    public IBookService bookService = new BookServiceImpl();
//    public IAuthorService authorService = new AuthorServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if(url.contains("/admin/books")){
//            List<Book> list = bookService.findAll();
//            req.setAttribute("books", list);
//            req.getRequestDispatcher("/views/admin/videoList.jsp").forward(req, resp);
//        }
//        else if(url.contains("/admin/book-add")){
//            req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//        }
//        else if(url.contains("/admin/book-upload")){
//            int id = Integer.parseInt(req.getParameter("id"));
//            Book book = bookService.findById(id);
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
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url = req.getRequestURI();
//        if(url.contains("/admin/book-insert")){
//            String coverImage = req.getParameter("coverImage");
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
//            String alertMsg = "";
//
//            if (title.isEmpty()||author.isEmpty()||publisher.isEmpty()||description.isEmpty()) {
//                alertMsg = "Please fill all fields";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//                return;
//            }
//
//            if (publishDate.after(new Date())) {
//                alertMsg = "Please select a valid date";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//                return;
//            }
//
//            if (isbn < 0 || price < 0|| quantity < 0) {
//                alertMsg = "Please select a valid number";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//                return;
//            }
//
//            if (bookService.findBookByTitle(title) != null) {
//                alertMsg = "Title already exists";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//                return;
//            }
//            Author author1 = authorService.findAuthorByName(author);
//            if (author1 == null) {
//                alertMsg = "Author does not exist";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//                return;
//            }
//
////            Dua du lieu vao model
//            Book book = new Book();
//            book.setTitle(title);
//            book.setPublisher(publisher);
//            book.setDescription(description);
//            book.setIsbn(isbn);
//            book.setPrice(price);
//            book.setQuantity(quantity);
//            book.setPublishDate(publishDate);
//            book.getAuthorList().add(author1);
//            author1.getListbooks().add(book);
//
//            String image = "";
//            String uploadPath = req.getServletContext().getRealPath("") + File.separator + Constants.DIR;
//            File uploadDir = new File(uploadPath);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//            try {
//                Part part = req.getPart("coverImage");
//                if (part.getSize() > 0){
//                    String fileName = part.getSubmittedFileName();
//                    int index = fileName.lastIndexOf(".");
//                    String fileExtension = fileName.substring(index+1);
//                    image = System.currentTimeMillis()+"."+fileExtension;
//                    part.write(uploadPath + File.separator + image);
//                    book.setCoverImage(image);
//                }
//                else if (coverImage != null){
//                    book.setCoverImage(coverImage);
//                }
//                else {
//                    book.setCoverImage("./upload/demo_1.png");
//                }
//            }catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            if (!bookService.insertBook(book)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/views/admin/addVideo.jsp").forward(req, resp);
//                return;
//            }
//            else {
//                resp.sendRedirect(req.getContextPath() + "/admin/books");
//            }
//        }
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
//    }
//}
//
