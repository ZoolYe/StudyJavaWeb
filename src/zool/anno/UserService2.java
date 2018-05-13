package zool.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService2 {

    /*1.定义dao类型属性,2.在属性上面使用注解，完成对象注入*/
    /*@Autowired
    UserDao2 userDao2;*/

    /*注入属性的第二种注解*/
    @Resource(name = "userDao2")
    UserDao2 userDao2;

    public void add(){
        System.out.println("service add .....");
        userDao2.add();
    }

}
