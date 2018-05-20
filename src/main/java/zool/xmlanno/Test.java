package zool.xmlanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test

    public void test1(){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.add();
    }
}
