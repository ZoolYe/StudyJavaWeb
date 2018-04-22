package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*用include实现页面包含*/
public class RequestDemo07 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/public/head.jsp").include(req,resp);
        resp.getWriter().write("asdadasdadas<br/>");
        req.getRequestDispatcher("/public/foot.jsp").include(req,resp);
    }
}
