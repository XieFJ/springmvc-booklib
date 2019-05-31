package cn.edu.zucc.booklib.dao;

import java.util.List;

import cn.edu.zucc.booklib.databean.BeanSystemUser;

public interface UserDAO {
	public List<BeanSystemUser> findAll();
}
