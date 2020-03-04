package com.login.service;

import com.login.entity.LoginUser;

public interface UserService {
    /*
    登录
     */
    LoginUser userLogin(String username,String password);
    /*
    注册
     */
    void zhuRegis(LoginUser zhuce);

    /*
    点击邮箱的激活码进行激活，根据激活码找到用户，之后在修改用户状态激活
     */
    LoginUser checkCode(String code);
    /*
    激活账户，修改账户状态
     */
    void updateActivateStatus(LoginUser user);
    /*
    登录，根据状态查询
     */
//    LoginUser loginUser(LoginUser user);

}
