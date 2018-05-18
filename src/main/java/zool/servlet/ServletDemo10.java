package zool.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取资源文件
 */
public class ServletDemo10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStream is = this.getServletContext().getResourceAsStream("/db.properties");

        Properties properties = new Properties();
        properties.load(is);

        String url = properties.getProperty("url");
        String username= properties.getProperty("username");
        String password = properties.getProperty("password");

        String rd = url+"\n"+username+"\n"+password;

        this.getServletContext().setAttribute("rd",rd);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/2.jsp");
        dispatcher.forward(req,resp);
    }
}
