package zool.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletDemo09 extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = "Spring Boot";
        //把数据带给jsp不能通过context域，要通过request域
        this.getServletContext().setAttribute("data",data);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/1.jsp");
        rd.forward(req,resp);
    }
}
