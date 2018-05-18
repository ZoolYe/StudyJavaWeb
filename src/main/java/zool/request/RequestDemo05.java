package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发，以及使用request域对象把数据带给转发资源
 * 请求转发的特点
 * 1，客户端只发出一次请求，而服务器端有多个资源调用
 * 2，浏览器地址栏不会发生变化
 */
public class RequestDemo05 extends HttpServlet {

    /**
     * mvc (mode (javabean) v view(jsp) c controller(servlet))
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date = "asaaaasaasas";

        req.setAttribute("data",date);

        /*通过request实现转发*/
        req.getRequestDispatcher("/message.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
