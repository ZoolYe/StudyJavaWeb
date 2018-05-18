package zool.respones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/*在servlet中用outputstream输出中文的问题*/
public class ResponesDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = "中国";
        OutputStream os = resp.getOutputStream();

        os.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());

        os.write(date.getBytes("UTF-8"));

    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = "中国";
        OutputStream os = resp.getOutputStream();
        *//*程序以什么码表输出了，程序就一定要控制浏览器以什么码表打开*//*
        resp.setHeader("Content-type","text/html;charset=GB2312");
        os.write(date.getBytes("UTF-8"));
    }*/

}
