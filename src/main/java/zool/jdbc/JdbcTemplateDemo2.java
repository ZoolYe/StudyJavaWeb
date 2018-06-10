package zool.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.beans.PropertyVetoException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo2 {

    @Test
    public void testList() throws PropertyVetoException {

        //已配置文件的方式实现
        /*ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        c3p0.setDriverClass("com.mysql.jdbc.Driver");
        c3p0.setJdbcUrl("jdbc:mysql:///test");
        c3p0.setUser("root");
        c3p0.setPassword("123456");*/

        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql = "select * from user";
        //调用jdbcTemplate的方法实现
        List<User> list = jdbcTemplate.query(sql,new MyRowMapper());
        System.out.println(list);
    }

    //查询返回对象
    @Test
    public void testObject(){

        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql ="select * from user where id = ?";
        //调用jdbcTemplate的方法实现
        //第二个参数是一个接口RowMapper,需要自己写类来实现接口，自己做数据封装
        User user = jdbcTemplate.queryForObject(sql,new MyRowMapper(),"2");
        System.out.println(user);
    }

    //jdbc实现带代码
    @Test
    public void testJDBC(){
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn = (Connection) DriverManager.getConnection("jdbc:mysql:///test","root","123456");
            //编写sql
            String sql = "select * from user where id =?";
            //预编译sql
            psmt = (PreparedStatement) conn.prepareStatement(sql);
            //设置参数的值
            psmt.setString(1,"2");
            //执行sql
            rs = (ResultSet) psmt.executeQuery();
            //遍历结果集
            while (rs.next()){
                //得到返回的结果值
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User();
                user.setPassword(password);
                user.setUsername(username);
                System.out.println(user.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                conn.close();
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //1.查询表中有多少条记录
    @Test
    public void testCount(){

        //创建对象，设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql = "select count(*) from user";

        //调用jdbcTemplate的方法
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

}
