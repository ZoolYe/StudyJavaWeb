package zool.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

    //1.添加
    @Test
    public void add(){

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
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)";
        int rows = jdbcTemplate.update(sql,3,"zool","123456","zoolye","男","中国","浙江","杭州","西湖","xxx","xxxxxxxxx","1234567890");
        System.out.println(rows);
    }

    //2.修改
    @Test
    public void update(){

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
        String sql = "update user set name=? where id=?";
        int rows = jdbcTemplate.update(sql,"xxx",2);
        System.out.println(rows);
    }

    //3.删除
    @Test
    public void delete(){

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
        String sql = "delete from user where id =?";
        jdbcTemplate.update(sql,1);
    }

}
