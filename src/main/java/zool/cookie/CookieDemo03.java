package zool.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/*代表首页*/
public class CookieDemo03 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        /*1.输出网站所有商品*/
        out.write("本网站有如下商品：</br>");
        Map<String, Book> map = Db.getAll();
        for (Map.Entry<String, Book> book : map.entrySet()) {
            Book b = book.getValue();
            out.print("<a href='/cookie4?id=" + b.getId() + "'target='_blank'>" + b.getName() + "</a></br>");
        }

        /*2.显示用户曾经看过的商品*/
        out.print("</br>你最近浏览过的商品:</br>");
        Cookie cookies[] = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if(cookies[i].getName().equals("bookHistory")){
                String ids[] = cookies[i].getValue().split("\\,");
                for (String id : ids){
                    Book book = (Book) Db.getAll().get(id);
                    out.print(book.getName()+"</br>");
                }
            }
        }
    }
}

class Db {
    private static Map<String, Book> map = new LinkedHashMap<String, Book>();

    static {
        map.put("1", new Book("1", "疯狂Java讲义", "李刚", "89￥"));
        map.put("2", new Book("2", "第一行代码", "郭霖", "65￥"));
        map.put("3", new Book("3", "Spring实战", "xxx", "123￥"));
        map.put("4", new Book("4", "SpringBoot", "yyy", "125￥"));
    }

    public static Map getAll() {
        return map;
    }
}


class Book {
    private String id;
    private String name;
    private String author;
    private String description;

    public Book() {
        super();
    }

    public Book(String id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}