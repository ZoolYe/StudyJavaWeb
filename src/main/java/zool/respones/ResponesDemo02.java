package zool.respones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponesDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text,html;charset=UTF-8");
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        *//*设置Response码表,以控制Response以什么码表想浏览器写出数据*//*
        resp.setCharacterEncoding("UTF-8");
        *//*指定浏览器以什么码表打开数据*//*
        resp.setHeader("content-type","text,html;charset=UTF-8");
        String date = "中国";
        PrintWriter pw = resp.getWriter();
        pw.write(date);
    }*/
}
