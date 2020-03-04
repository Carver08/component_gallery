package com.login.service;

import com.login.dao.UserDao;
import com.login.entity.LoginUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;
    /*
    邮件接口
     */
    @Resource
    private MailService mailService;

    //登录
    public LoginUser userLogin(String username, String password){
        return userDao.findByName(username,password);
    }
    //注册，同时发送一封邮件
    public void zhuRegis(LoginUser zhuce){
        userDao.findRegis(zhuce);
        //获取激活码
        String code = zhuce.getCode();
        System.out.println("code:"+code);
        //主题
        String subject = "来邮件注册的激活邮件！";
        //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=\"/user/checkCode?code ="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendHtmlMail(zhuce.getMail(),subject,context);
    }

    /*
    根据激活码查询用户
     */
    @Override
    public LoginUser checkCode(String code) {
        return userDao.checkCode(code);
    }

    @Override
    public void updateActivateStatus(LoginUser user) {
        userDao.updateActivateStatus(user);
    }

//    @Override
//    public LoginUser loginUser(LoginUser user) {
//        return null;
//    }

}
