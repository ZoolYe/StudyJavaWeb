package zool.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import zool.pojo.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : zoolye
 * @date : 2018-07-15 21:28
 */
public class Test {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        //mybatis配置文件
        String resource = "mybatis.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂,传入mybatis的配置信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @org.junit.Test
    public void test() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用userMapper的方法
        User user = userMapper.findUserById(629);
        System.out.println(user);
    }

}
