package zool.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        OrdersService ordersService = (OrdersService) context.getBean("ordersService");
        ordersService.accountMoney();
    }

}
