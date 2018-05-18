package zool.beanJavaConfig;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testConfig {

    @Test
    public void testConfig(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

        DemoPrototypeService d1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService d2 = context.getBean(DemoPrototypeService.class);

        System.out.println(s1.equals(s2));

        System.out.println(d1.equals(d2));

        //context.close();

    }

    @Test
    public void testConfig2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);
        elConfig.outputResource();
    }

}
