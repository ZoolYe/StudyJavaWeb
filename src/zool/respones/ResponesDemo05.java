package zool.respones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/*控制浏览器定时刷新*/
public class ResponesDemo05 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*开发中使用的*/
        String message = "<meta http-equiv='refresh' content='3;url=/download/zhuomian.jpg'>恭喜你注册成功，将在3秒后跳转至首页，<a href='/download/zhuomian.jpg'>跳转</a>";
        this.getServletContext().setAttribute("message",message);
        this.getServletContext().getRequestDispatcher("/message.jsp").forward(req,resp);
    }

    public void test2(HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh","3;url='/download/zhuomian.jpg'");
        resp.getWriter().write("恭喜你注册成功，将在3秒后跳转至首页，<a href='/download/zhuomian.jpg'>跳转</a>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void test1(HttpServletResponse resp) throws IOException {
        /*告诉浏览器，每隔三秒访问一下服务器*/
        resp.setHeader("refresh", "3");
        String data = new Random().nextInt(10000) + "";
        resp.getWriter().write(data);
    }
}
