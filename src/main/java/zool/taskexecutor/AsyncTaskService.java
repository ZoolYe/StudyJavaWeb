package zool.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Async 注解表明改方法是一个异步任务，如果该注解在类级别，表明该类中的所有方法都是异步任务
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }

    @Async
    public void executeAsyncTaskPuls(Integer i){
        System.out.println("执行异步任务1："+(i+1));
    }

}
