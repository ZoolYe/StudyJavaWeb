package zool.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
@Data
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
