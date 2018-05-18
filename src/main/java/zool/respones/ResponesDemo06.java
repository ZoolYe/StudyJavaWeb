package zool.respones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*控制浏览器缓存*/
public class ResponesDemo06 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*设置浏览器缓存，并设置缓存时间*/
        resp.setDateHeader("expries",System.currentTimeMillis()+1000*3600);
        String data = "aaaaaaaaaaaaaaaaaaa";
        resp.getWriter().write(data);
    }
}
