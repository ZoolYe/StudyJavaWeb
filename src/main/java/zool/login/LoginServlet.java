package zool.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        List<User> list = Db.getAll();
        for (User user : list) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                req.getSession().setAttribute("user",user);
                resp.sendRedirect("/index.jsp");
                return;
            }
        }

        resp.getWriter().write("用户名或密码不正确!");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

class Db {

    public static List list = new ArrayList();

    static {
        list.add(new User("aaa", "123"));
        list.add(new User("bbb", "456"));
        list.add(new User("ccc", "789"));
    }

    public static List getAll() {
        return list;
    }

}

class User {

    private String name;
    private String password;

    public User() {
        super();
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}