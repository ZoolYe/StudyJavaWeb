package zool.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zool.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo01 {

    //根据id查询用户信息，得到一条记录的结果
    @Test
    public void findUserById() throws IOException {

        //mybatis配置文件
        String resource = "mybatis.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂,传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //通过SqlSession操作数据库
        //第一个参数：映射文件中的statement的id，等于=namespace+statement的id
        //第二个参数：指定和映射文件中所匹配的paramenterType类型的参数
        //sqlSession.selectOne结果是与映射文件中所匹配的paramenterType类型对象
        User user = sqlSession.selectOne("test.findUserById", 2);
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void findUserByName() throws IOException {
        //mybatis配置文件
        String resource = "mybatis.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂,传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //list中的user和映射文件中的paramenterType所指定的类型一致
        List<User> list = sqlSession.selectList("test.findUserByName", "zool");
        System.out.println(list);
        //释放资源
        sqlSession.close();
    }

    @Test
    public void insertUser() throws IOException {

        User user = new User();
        user.setUsername("zsadasd");
        user.setAddress("dasdasdasdasdas");
        user.setArea("dasda");
        user.setCity("dasdasdas");
        user.setCountry("dasdasdasd");
        user.setName("dasdasdasd");
        user.setPassword("dasdasdasdas");
        user.setProvince("dasdasdas");
        user.setProvincialcertificate("asdasdasdd");
        user.setSex("h");
        user.setStreet("dasdasdas");

        //mybatis配置文件
        String resource = "mybatis.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂,传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //list中的user和映射文件中的paramenterType所指定的类型一致
        sqlSession.insert("test.insertUser", user);

        //提交事务
        sqlSession.commit();

        //获取用户信息主键
        user.getId();
        System.out.println(user.getId());

        //释放资源
        sqlSession.close();
    }

    @Test
    public void deleteByUserId() throws IOException {

        //mybatis配置文件
        String resource = "mybatis.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂,传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //传入id删除用户
        sqlSession.delete("test.deleteUser", 627);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    public void updateUserById() throws IOException {

        //mybatis配置文件
        String resource = "mybatis.xml";

        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建会话工厂,传入mybatis的配置信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(629);
        user.setUsername("zoolye");
        user.setPassword("123456");
        user.setName("zool");
        user.setSex("男");
        user.setCountry("xxxxxx");
        user.setProvince("xxxxx");
        user.setCity("xxxxx");
        user.setArea("xxxxx");
        user.setStreet("xxxxx");
        user.setAddress("xxxxx");
        user.setProvincialcertificate("xxxxxx");

        //传入id删除用户
        sqlSession.update("test.updateUser", user);

        //提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();

    }

}
