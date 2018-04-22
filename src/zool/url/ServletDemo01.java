package zool.url;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo01 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/form3.html").forward(req,resp);

        resp.sendRedirect("/");

        this.getServletContext().getRealPath("/");

        this.getServletContext().getResourceAsStream("/");

        /**
         * <a href="">点点</a>
         * <form action=""></form>
         */

    }
}
