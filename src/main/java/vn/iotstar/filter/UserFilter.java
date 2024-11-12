//package vn.iotstar.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import vn.iotstar.Entity.User;
//
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/user/*")
//public class UserFilter implements Filter {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//
//        HttpSession session = request.getSession();
//        Object obj = session.getAttribute("account");
//        User user = (User) obj;
//
//        if (user != null && !user.isAdmin()) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//        else {
//            response.sendRedirect(request.getContextPath() + "/login");
//        }
//    }
//}
