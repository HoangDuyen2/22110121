//package vn.iotstar.Controller.user;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import vn.iotstar.Entity.Book_User_ID;
//import vn.iotstar.Entity.Rating;
//import vn.iotstar.Entity.User;
//import vn.iotstar.Service.IBookService;
//import vn.iotstar.Service.IRatingService;
//import vn.iotstar.Service.IUserService;
//import vn.iotstar.Service.impl.BookServiceImpl;
//import vn.iotstar.Service.impl.RatingService;
//import vn.iotstar.Service.impl.UserServiceImpl;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = {"/user/reviews","/user/book-reviews","/user/review"})
//public class BookController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    IBookService bookService = new BookServiceImpl();
//    IUserService userService = new UserServiceImpl();
//    IRatingService ratingService = new RatingService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uri = req.getRequestURI();
//        if (uri.contains("/user/reviews")) {
//            List<Object[]> list = ratingService.findAllRatings();
//            req.setAttribute("reviews", list);
//            req.getRequestDispatcher("/views/user/videoList.jsp").forward(req, resp);
//        }
//        if(uri.contains("/user/book-review")){
//            Object[] objects = ratingService.findRatingById(Integer.parseInt(req.getParameter("id")));
//            req.setAttribute("review", objects);
//            req.getRequestDispatcher("/views/user/reviewList.jsp").forward(req, resp);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String review = req.getParameter("review-text");
//        String title = req.getParameter("title");
//        int id = Integer.parseInt(req.getParameter("id"));
//
//        String alertMsg = "";
//
//        HttpSession session = req.getSession();
//        if (session.getAttribute("account") != null) {
//            User user = (User) session.getAttribute("account");
//            Rating rating = new Rating();
//            rating.setId(new Book_User_ID(user.getId(),id));
//            rating.setReviewText(review);
//            rating.setBook(bookService.findBookByTitle(title));
//            rating.setUser(user);
//            if (!ratingService.insertRating(rating)) {
//                alertMsg = "Something went wrong";
//                req.setAttribute("alertMsg", alertMsg);
//                req.getRequestDispatcher("/admin/book-reviews?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//                return;
//            }
//            resp.sendRedirect(req.getContextPath() + "/user/reviews");
//        }
//        alertMsg = "Something went wrong";
//        req.setAttribute("alertMsg", alertMsg);
//        req.getRequestDispatcher("/admin/book-reviews?id=" + id).forward(req, resp);  // Chuyển tiếp đến JSP
//    }
//}
