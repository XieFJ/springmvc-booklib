package cn.edu.zucc.booklib.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.zucc.booklib.dao.UserDAO;
import cn.edu.zucc.booklib.databean.BeanSystemUser;
import cn.edu.zucc.booklib.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public List<BeanSystemUser> findAll() {
		
		return this.userDao.findAll();
	}

}
