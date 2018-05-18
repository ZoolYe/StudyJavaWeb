package zool.shopping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/*网站首页，列出所有书*/
public class ListBookServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("本网站有如下商品：<br/>");
        Map<String,Book> map = Db.getAll();
        for (Map.Entry<String,Book> bookEntry : map.entrySet()){
            Book book = bookEntry.getValue();
            out.print(book.getName()+"<a href='/buyServlet?id="+book.getId()+"'target='_blank'>购买</a><br/>");
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