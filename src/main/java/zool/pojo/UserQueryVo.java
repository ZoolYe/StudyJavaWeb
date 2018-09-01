package zool.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author : zoolye
 * @date : 2018-07-22 16:04
 */
@Data
public class UserQueryVo {

    //在这里包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;

    private List<Integer> ids;

}
