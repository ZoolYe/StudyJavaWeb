package zool.shopping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/*显示用户购买的商品*/
public class ListCartServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (session == null){
            out.print("你没有购买任何商品");
            return;
        }

        out.print("你购买了如下商品：<br/>");
        List<Book> list = (List) session.getAttribute("list");
        for (Book book : list){
            out.print(book.getName()+" : "+book.getDescription());
        }
    }
}
