package zool.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bean2Test {

    @Test
    public void bean2Test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        System.out.println(bean2);
    }

}
