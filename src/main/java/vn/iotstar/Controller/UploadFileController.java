package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import vn.iotstar.Utils.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(urlPatterns = "/images")
public class UploadFileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imageName = req.getParameter("coverImage");
        resp.setContentType("image/png");
        File file = new File(Constants.DIR+"/"+imageName);
        if (file.exists()) {
            IOUtils.copy(new FileInputStream(file), resp.getOutputStream());
        }
    }
}
