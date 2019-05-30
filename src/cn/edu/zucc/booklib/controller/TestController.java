package cn.edu.zucc.booklib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value="/test")
    public String handleRequest(HttpServletRequest request) throws Exception {
    	request.setAttribute("msg", "hello world");
    	
		return "test";
	}
    
}
