package zool.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * servletContext 域:
 * 1，这是一个容器
 * 2，servletContext 域:这句话说明了这个容器的作用范围，也就是应用程序范围
 * 通过servletContext实现了ServletDemo07和ServletDemo08的数据共享
 */
public class ServletDemo07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String data = "SpringBoot";

        this.getServletContext().setAttribute("data",data);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
