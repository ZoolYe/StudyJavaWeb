package zool.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int num) throws SQLException {
        User user = new User();

        //1.从结果集里面得到数据
        //2.把得到的数据封装到对象里面
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }

}
