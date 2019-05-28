package cn.edu.zucc.booklib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String test(){
//    实际返回的是WEB-INF/html/test.html ,springmvc-config.xml中配置过前后缀
        return "/WEB-INF/html/test.html";
    }
}
