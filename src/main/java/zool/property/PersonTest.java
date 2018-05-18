package zool.property;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {

    @Test
    public void personTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Person p = (Person) context.getBean("person");
        p.test1();
    }

}
