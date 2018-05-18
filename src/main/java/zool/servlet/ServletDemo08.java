package zool.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取应用程序初始化参数
 */
public class ServletDemo08 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = (String) this.getServletContext().getAttribute("data");
        System.out.println(data);

        String value = this.getServletContext().getInitParameter("contextParam");
        resp.getOutputStream().write(value.getBytes());
        resp.getOutputStream().write("<font color='red'>我草你妈</font>".getBytes());
    }
}

