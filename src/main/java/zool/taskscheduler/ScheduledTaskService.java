package zool.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");


    /**
     * @Scheduled 声明该方法是计划任务
     * fixedRate 属性每隔固定时间执行
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔5秒执行一次 "+DATE_FORMAT.format(new Date()));
    }

    /**
     * cron 属性可按照指定时间执行 每天 11点28分
     */
    @Scheduled(cron =  "0 28 11 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间内执行 "+DATE_FORMAT.format(new Date())+"执行");
    }

}
