package zool.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

/*显示商品详细信息*/
public class CookieDemo04 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        /*1.根据用户带过来的id号，显示相应商品的详细信息*/
        String id = req.getParameter("id");
        Book book = (Book) Db.getAll().get(id);
        out.print(book.getId() + "    " + book.getName() + "  " + book.getAuthor() + "  " + book.getDescription() + "</br>");

        /*2.构建cookie，回写给浏览器*/
        String cookieValue = buildCookie(id, req);
        Cookie cookie = new Cookie("bookHistory", cookieValue);
        cookie.setMaxAge(1 * 30 * 24 * 60 * 60);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    private String buildCookie(String id, HttpServletRequest req) {
        String bookHistory = null;
        Cookie cookie[] = req.getCookies();
        for (int i = 0; cookie != null && i < cookie.length; i++) {
            if (cookie[i].getName().equals("bookHistory")) {
                bookHistory = cookie[i].getValue();
            }
        }
        if (bookHistory == null) {
            return id;
        }
        LinkedList<String> linkedList = new LinkedList(Arrays.asList(bookHistory.split("\\,")));
        if (linkedList.contains(id)) {
            linkedList.remove(id);
            linkedList.addFirst(id);
        } else {
            if (linkedList.size() >= 3) {
                linkedList.removeLast();
                linkedList.addFirst(id);
            } else {
                linkedList.addFirst(id);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String bid : linkedList){
            sb.append(bid+",");
        }
        return sb.deleteCharAt(sb.length()-1).toString();

    }

}
