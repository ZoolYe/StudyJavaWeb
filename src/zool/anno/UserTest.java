package zool.anno;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void userTset(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = (User) context.getBean("user");
        User user1 = (User) context.getBean("user");
        System.out.println(user1);
        System.out.println(user);
        user.add();
    }

    @Test
    public void userServiceTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService2 userService2 = (UserService2) context.getBean("userService2");
        userService2.add();
    }

}
