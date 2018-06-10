package zool.txanno;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrdersService {

    private OrdersDao ordersDao;
    public void setOrdersDao(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public void accountMoney(){
        //-1000
        ordersDao.lessMoney();

        //出现异常
        int i = 1/0;

        //+1000
        ordersDao.moreMoney();
    }

}
