package zool.beanJavaConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class DemoService {

    @Value("其它类的属性")
    private String another;

}
