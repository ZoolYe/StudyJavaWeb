package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/*获取请求头和请求数据*/
public class RequestDemo02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String,String[]> map = req.getParameterMap();
        String value = req.getParameter(String.valueOf(map.get("username")));

        System.out.println(value);
    }

    public void test2(HttpServletRequest req) {
        String username = req.getParameter("username");
        System.out.println(username);

        Enumeration enumeration = req.getParameterNames();
        while (enumeration.hasMoreElements()){
            String name = (String) enumeration.nextElement();
            String value = req.getParameter(name);
            System.out.println(name+" = "+value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void test1(HttpServletRequest req) {
        String accept = req.getHeader("Accept");
        System.out.println(accept);
    }
}
