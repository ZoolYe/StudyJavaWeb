package zool.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Book book = (Book) context.getBean("book");
        book.add();
    }

}
