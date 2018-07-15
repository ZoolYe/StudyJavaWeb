package zool.mybatis.dao;

import zool.pojo.User;

/**
 * @author : zoolye
 * @date : 2018-07-15 19:24
 */
public interface UserDao {

    //根据id查询用户的信息
    public User findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;

}
