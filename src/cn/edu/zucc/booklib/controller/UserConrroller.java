package cn.edu.zucc.booklib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.zucc.booklib.service.UserService;

@Controller
public class UserConrroller {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public String findAll() {
		
		return userService.findAll().get(0).getUserName();
	}
}
