package cn.edu.zucc.booklib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String test(){
//    ʵ�ʷ��ص���WEB-INF/html/test.html ,springmvc-config.xml�����ù�ǰ��׺
        return "/WEB-INF/html/test.html";
    }
}
