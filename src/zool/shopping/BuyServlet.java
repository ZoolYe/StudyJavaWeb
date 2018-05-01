package zool.shopping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*完成购买*/
public class BuyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = (Book) Db.getAll().get(id);

        HttpSession session = req.getSession();

        List list = (List) session.getAttribute("list");
        if (list == null) {
            list = new ArrayList();
            session.setAttribute("list",list);
        }
        list.add(book);
        resp.sendRedirect("/listCart");

    }
}
