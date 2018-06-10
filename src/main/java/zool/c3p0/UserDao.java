package zool.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    //得到JdbcTemplate对象
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加操作
    public void add() {
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,4,"chenmeng","123456","chenmeng","女","中国","浙江","杭州","西湖","xxx","xxxxxxxxx","0987654321");
    }
}
