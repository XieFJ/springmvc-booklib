package cn.edu.zucc.booklib.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.zucc.booklib.dao.UserDAO;
import cn.edu.zucc.booklib.databean.BeanSystemUser;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return this.sessionFactory.openSession();
	}
	
	@Override
	public List<BeanSystemUser> findAll() {
		Session session = getCurrentSession();
		List<BeanSystemUser> result = new ArrayList<>();
		
		String hql = "from BeanSystemUser u where u.isDelete=0";
		result = session.createQuery(hql).list();
		
		return result;
	}

}
