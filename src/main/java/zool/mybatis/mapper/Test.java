package zool.mybatis.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import zool.pojo.User;
import zool.pojo.UserCustom;
import zool.pojo.UserQueryVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    /**
     * 用户信息综合查询
     * @throws Exception
     */
    @org.junit.Test
    public void test2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //创建UserMapper对象,mybatis自动生成mapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo = new UserQueryVo();

        UserCustom userCustom = new UserCustom();
        userCustom.setSex("男");

        userQueryVo.setUserCustom(userCustom);

        //调用userMapper的方法
        List<UserCustom> list = userMapper.findUserList(userQueryVo);

        System.out.println(list);

    }

}
