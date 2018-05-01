package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDemo08 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String referer = req.getHeader("referer");
        if (referer == null || !referer.startsWith("http://localhost")) {
            /*重定向*/
            resp.sendRedirect("http://www.zoolye.com");
            return;
        }
        String data = "Spring Boot 博客";
        resp.getWriter().write(data);
    }
}
