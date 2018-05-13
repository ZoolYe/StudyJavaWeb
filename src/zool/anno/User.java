package zool.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")  //<bean id="user" class=""/>
@Scope(value = "prototype")
public class User {

    public void add(){
        System.out.println("user add ");
    }

}
