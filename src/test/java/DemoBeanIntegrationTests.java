import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zool.fortest.TestBean;
import zool.fortest.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)//在JUnit环境下提供Spring TestContext Framework的功能
@ContextConfiguration(classes = {TestConfig.class})//用来加载配置ApplicationContext其中，classes属性用来加载配置类
@ActiveProfiles("dev")//用来声明活动的profile
public class DemoBeanIntegrationTests {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject(){
        String expected = "from dev profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }

}
