package cn.edu.zucc.booklib.service;

import java.util.List;

import cn.edu.zucc.booklib.databean.BeanSystemUser;

public interface UserService {
	public List<BeanSystemUser> findAll();
}
