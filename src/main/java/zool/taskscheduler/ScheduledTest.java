package zool.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledTest {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);
    }

}
