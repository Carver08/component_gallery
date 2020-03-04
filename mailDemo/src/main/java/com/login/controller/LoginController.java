package com.login.controller;

import com.login.dao.UserDao;
import com.login.entity.LoginUser;
import com.login.service.UserService;
import com.login.util.FerificUtil;
import com.login.util.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;

    //登录页面
    @RequestMapping("/hello")
    public String show(){
        return "login";
    }
    //登录
    @RequestMapping("/loginP")
    public String loginSyS(String username,String password) {
        if(!"".equals(username) && username!=null){
//            message.equals("输入框不能为空");
        }
        LoginUser tna = userService.userLogin(username,password);
        if( tna != null ){
            return "welcome";
        }
        return "shibai";
    }

    //注册页面
    @RequestMapping("/register")
    public String reg(){
        return "regis";
    }
    //注册
    @RequestMapping("/regisZC")
    public String regisZC(LoginUser zhuce){
        zhuce.setStatus("1");
        String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
        zhuce.setCode(code);
        userService.zhuRegis(zhuce);
        return "emailWelcome";
    }
    /*
    验证邮箱的code激活账户
    首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @RequestMapping(value = "/checkCode")
    public String checkCode(String code){
        LoginUser user = userService.checkCode(code);
        System.out.println(user);
        //如果用户不等于null，把用户状态修改status=1
        if(user != null){
            user.setStatus("1");
            //把code验证清空，因为已经不需要了
            user.setCode("");
            System.out.println(user);
            userService.updateActivateStatus(user);
        }
        return "login";
    }
    //返回登录页面
    @RequestMapping("/regisLogin")
    public String regisLogin(){
        return "login";
    }

    /*
    图形验证码
     */
//    @RequestMapping(value = "/getImg", method = {RequestMethod.POST, RequestMethod.GET})
//    protected void createImg(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        //1.生成随机的验证码及图片
//        Object[] objs = FerificUtil.createImage();
//        //2.将验证码存入session
//        String imgcode = (String) objs[0];
//        HttpSession session = req.getSession();
//        session.setAttribute("imgcode", imgcode);
//        //3.将图片输出给浏览器
//        BufferedImage img = (BufferedImage) objs[1];
//        res.setContentType("image/png");
//        //服务器自动创建输出流，目标指向浏览器
//        OutputStream os = res.getOutputStream();
//        ImageIO.write(img, "png", os);
//        os.close();
//    }

}
