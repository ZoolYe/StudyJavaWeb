package zool.tx;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrdersDao {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
   }

   //少钱
   public void lessMoney(){
        String sql = "update account set salary = salary-? where username = ?" ;
        jdbcTemplate.update(sql,1000,"zoolye");
   }

   //多钱
   public void moreMoney(){
       String sql = "update account set salary = salary+? where username = ?" ;
       jdbcTemplate.update(sql,1000,"chenmeng");
   }

}
