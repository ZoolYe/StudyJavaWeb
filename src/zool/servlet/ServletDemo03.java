package zool.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

public class ServletDemo03 extends HttpServlet{
    @Override
    public void init(ServletConfig config) {
        System.out.println("servlet被创建");
    }

    @Override
    public void destroy() {
        System.out.println("servlet被销毁");
    }
}
