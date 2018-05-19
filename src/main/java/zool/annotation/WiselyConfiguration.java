package zool.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 组合注解：
 * 组合注解这个就比较好理解了，就是将多个注解组合到一块生成一个新的注解。
 * 使用这个新的注解就相当于使用了该组合注解中所有的注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface WiselyConfiguration {
    String[] value() default {};
}
