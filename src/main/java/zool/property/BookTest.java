package zool.property;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookTest {

    @Test
    public void bookTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = (Book) context.getBean("book");
        book.demoBook();
    }

}
