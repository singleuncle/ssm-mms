package com.uncle.service;

import com.uncle.bean.JdUser;
import com.uncle.mapper.JdUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description: 用户的业务层
* @Author: 步尔斯特
* @Date: 2021/3/5
*/
@Service("userService")
public class JdUserService {

    @Autowired
    private JdUserDAO userDao;

    /*
     * @Description: 通过用户名和密码查询的业务层方法
     * @Param: [login_name, password]
     * @return: com.uncle.bean.JdUser
     * @Author: 步尔斯特
     * @Date: 2021/3/6
     */
    public JdUser login(String login_name, String password) {
        return userDao.findJdUser(login_name, password);
    }

    public boolean register(JdUser user) {

        try {
            return userDao.insertJdUser(user) == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
