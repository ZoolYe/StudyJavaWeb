package zool.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bean3Test {

    @Test
    public void beanTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Bean3 bean3 = (Bean3) context.getBean("bean3");
        bean3.add();
        System.out.println(bean3);
    }

}
