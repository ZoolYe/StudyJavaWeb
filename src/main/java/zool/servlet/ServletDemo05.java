package zool.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
*  servletConfig对象：用于封装servlet的配置信息
*  在实际开发中，有一些东西不适合在程序中写死，这类数据就可以通过配置的方式配给servlet
*  列如servlet采用哪种码表，servlet链接哪个数据库，servlet使用哪个配置文件
* */
public class ServletDemo05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到指定的配置信息
        String value1 = getInitParameter("data1");
        System.out.println(value1);

        //得到所有的配置信息
        Enumeration enumeration = getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String names = (String) enumeration.nextElement();
            String value2 = getInitParameter(names);
            System.out.println(value2);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
