package com.example.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addUser(User user){
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.update(user);
		session.close();
	}
	
	public void deleteUser(int userId){
		Session session = sessionFactory.openSession();
		session.delete(userId);
		session.close();
	}
	
	public List<User> listUserByType(int type,int offset,int limit){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("type", type));
		criteria.setFirstResult(offset);
		criteria.setMaxResults(limit);
		List<User> list = criteria.list();
		session.close();
		return list;
	}
	
	public User login(String email,String password){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = criteria.list();
		session.close();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
