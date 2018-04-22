package zool.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*forwar的细节,forwar时，会清空respone中的数据*/
public class RequestDemo06 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String data = "bbbbbbbbb";
        resp.getWriter().write(data);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
