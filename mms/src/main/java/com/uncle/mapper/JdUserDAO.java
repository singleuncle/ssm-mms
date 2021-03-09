package com.uncle.mapper;

import com.uncle.bean.JdUser;
import org.apache.ibatis.annotations.Param;
/**
* @Description: 用户的接口
* @Author: 步尔斯特
* @Date: 2021/3/6
*/
public interface JdUserDAO {
    /*
     * @Description: 通过用户名和密码去数据库里查询
     * @Param: [login_name, password]
     * @return: com.uncle.bean.JdUser
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    JdUser findJdUser(@Param("login_name") String  login_name,
                      @Param("password") String password);

    int    insertJdUser(JdUser  user);
}
