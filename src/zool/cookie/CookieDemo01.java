package zool.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CookieDemo01 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charser=UTF-8");

        PrintWriter out = resp.getWriter();
        out.write("<a href='/cookie2'>清空Cookie</a></br>");

        /*获取用户的时间cookie*/
        Cookie[] cookie = req.getCookies();
        for (int i=0;cookie!=null && i<cookie.length;i++) {
            if("lastAccessTime".equals(cookie[i].getName())){
                long time = Long.parseLong(cookie[i].getValue());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss SSS a");
                out.println("你上次的访问时间是："+sdf.format(new Date(time)));
            }
        }

        /*给用户回送最新的访问时间*/
        Cookie userCookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
        /*设置Cookie的有限期*/
        userCookie.setMaxAge(1*30*24*3600);
        /*设置有效路径*/
        userCookie.setPath("/");
        resp.addCookie(userCookie);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
