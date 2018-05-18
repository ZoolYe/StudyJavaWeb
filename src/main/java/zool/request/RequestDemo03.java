package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDemo03 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String []likes = req.getParameterValues("likes");

        for (int i = 0; likes!=null && i < likes.length; i++) {
            System.out.println(likes[i]);
        }
        String description = req.getParameter("description");
        System.out.println(description);
        System.out.println(username+" : "+password+" : "+gender+" : "+city);
    }
}
