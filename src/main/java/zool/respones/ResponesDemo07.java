package zool.respones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 重定向的特点
 * 1，浏览器会向服务器发送两次请求，意味着就有两个request和respones
 * 2，用重定向技术，浏览器地址栏会发生变化
 * 3，使用场景：用户登录和显示购物车时，通常会用到重定向技术
 */
public class ResponesDemo07 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setStatus(302);
        resp.setHeader("location","/index.jsp");*/

        /*请求重定向，地址栏会发生变化*/
        resp.sendRedirect("/index.jsp");

    }

}
