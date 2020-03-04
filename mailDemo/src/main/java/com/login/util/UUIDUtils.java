package com.login.util;

import java.util.UUID;

public class UUIDUtils {
    /*
    邮件注册随机生成激活码的工具类
     */
    public static String getUUID(){
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for(int i= 0;i<3;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        return code;
//        return UUID.randomUUID().toString().replace("-","");
    }

}
