package zool.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {

    //在方法上面使注解来完成增强的配置
    @Before(value = "execution(* zool.aop.aspectj.Book.*(..))")
    public void before1(){
        System.out.println("before.......");
    }
}
