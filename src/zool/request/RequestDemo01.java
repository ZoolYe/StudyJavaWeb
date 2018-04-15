package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*request的常用方法*/
public class RequestDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getQueryString());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getRemoteHost());
        System.out.println(req.getRemotePort());
        System.out.println(req.getMethod());
    }
}
