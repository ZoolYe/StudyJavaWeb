package zool.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import zool.pojo.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : zoolye
 * @date : 2018-07-15 19:49
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
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @org.junit.Test
    public void testFindUserById() throws Exception {
        //创建UserDao的对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(629);
        System.out.println(user);
    }

}
