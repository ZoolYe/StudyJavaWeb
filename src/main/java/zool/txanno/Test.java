package zool.txanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("txanno.xml");
        OrdersService ordersService = (OrdersService) context.getBean("ordersService");
        ordersService.accountMoney();
    }

}
