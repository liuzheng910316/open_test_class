package com.example.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
		String sql = "insert into user(name,password,type) values (?,?,?) ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, user.getName());
		query.setParameter(1, user.getPassword());
		query.setParameter(2, user.getType());
		query.executeUpdate();
		session.close();
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.openSession();
		String sql = "update user set name = ? where id = ? ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, user.getName());
		query.setParameter(1, user.getId());
		query.executeUpdate();
		session.close();
	}
	
	public void deleteUser(int userId){
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String sql = "delete from user where id = ? ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, userId);
		query.executeUpdate();
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
	
	public User login(String name,String password){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = criteria.list();
		session.close();
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
