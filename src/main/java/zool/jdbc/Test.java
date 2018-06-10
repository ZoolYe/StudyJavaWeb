package zool.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zool.c3p0.UserService;

public class Test {

    @org.junit.Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("c3p0.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }

}
