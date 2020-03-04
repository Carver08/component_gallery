package com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//首页控制类
public class IndexController {

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

}
