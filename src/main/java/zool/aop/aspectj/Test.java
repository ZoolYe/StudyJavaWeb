package zool.aop.aspectj;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.jupiter.api.Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop2.xml");
        Book book = (Book) context.getBean("book");
        book.add();
    }

}
