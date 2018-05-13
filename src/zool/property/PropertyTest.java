package zool.property;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyTest {

    @Test
    public void propertyTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        PropertyDemo01 demo01 = (PropertyDemo01) context.getBean("demo1");
        demo01.test();
    }

}
