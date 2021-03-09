package com.uncle.controller;

import com.uncle.bean.JdCategory;
import com.uncle.bean.JdUser;
import com.uncle.service.JdCategoryService;
import com.uncle.service.JdUserService;
import com.uncle.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 用户的控制类
 * @Author: 步尔斯特
 * @Date: 2021/3/5
 */
@Controller
public class JdUserController {

    @Autowired
    private JdUserService userService;
    @Autowired
    private JdCategoryService categoryService;

   /*
    * @Description: hello word
    * @Param: []
    * @return: java.lang.String
    * @Author: 步尔斯特
    * @Date: 2021/3/5
    */
    @RequestMapping("/toHello")
    public String toHello() {
        return "hello";
    }

    /*
     * @Description: 跳转登录
     * @Param: []
     * @return: java.lang.String
     * @Author: 步尔斯特
     * @Date: 2021/3/5
     */
    @RequestMapping("/toLogin")
    public String toLogin() {

        return "login";
    }

    /*
     * @Description: 用户登录
     * @Param: [login_name, password, request]
     * @return: java.lang.String
     * @Author: 步尔斯特
     * @Date: 2021/3/5
     */
    @RequestMapping("/login.do")
    public String login(String login_name, String password, HttpServletRequest request) {
        // 收到密码 对密码进行 MD5 和 加盐
        password = MD5Util.md5StrAndSalt(password, login_name);

        // 验证账户和密码是否存在
        JdUser jdUser = userService.login(login_name, password);
        // 如果用户不为空，证明用户存在
        if (jdUser != null) {
            //将jdUser存到session里
            request.getSession().setAttribute("jdUser", jdUser);
            // 登录成功 就获取图书的直接子分类列表
            List<JdCategory> categories = categoryService.subCategoryList(1);
            // 将查到的分类信息存到category里
            request.setAttribute("categories", categories);
            return "book";
        }
        // 如果没查到用户，将如下信息带回
        request.setAttribute("msg", "登录失败");
        return "login";
    }

    /*
     * @Description: 跳转注册
     * @Param: []
     * @return: java.lang.String
     * @Author: 步尔斯特
     * @Date: 2021/3/5
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /*
     * @Description: 用户注册
     * @Param: [user, request]
     * @return: java.lang.String
     * @Author: 步尔斯特
     * @Date: 2021/3/5
     */
    @RequestMapping("/register.do")
    public String register(JdUser user, HttpServletRequest request) {
        // 注册之前 对密码进行 MD5 和 加盐
        user.setPassword(MD5Util.md5StrAndSalt(user.getPassword(), user.getLogin_name()));
        boolean rf = userService.register(user);
        if (rf) {
            return "registerOk";
        }
        request.setAttribute("msg", "注册失败");
        return "register";
    }
}
