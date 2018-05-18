package zool.ioc;

import lombok.Data;

@Data
public class UserService {

    /*1.定义dao类型属性*/
    private UserDao userDao;

    /*2.生成set方法*/


    public void add(){
        System.out.println("service.......");
        userDao.add();
    }

}
