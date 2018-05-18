package zool.form;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoForm extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*String username = req.getParameter("username");
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(username);*/

        boolean b = isTokenValid(req);
        if (!b){
            System.out.println("阻止重复提交");
            return;
        }

        /*处理业务之前要移除掉session*/
        req.getSession().removeAttribute("token");
        /*处理业务逻辑*/

    }

    /*判断表单号是否有效*/
    private boolean isTokenValid(HttpServletRequest req) {

        String client_token = req.getParameter("token");
        if (client_token == null || "".equals(client_token)){
            return false;
        }
        String server_token = (String) req.getSession(false).getAttribute("token");
        if(server_token == null){
            return false;
        }
        if (!server_token.equals(client_token)){
            return false;
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
