package com.example.demo.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.SuscribeDao;
import com.example.demo.model.Suscribe;
@Repository
public class SuscribeDaoImpl implements SuscribeDao {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addSuscribe(Suscribe suscribe) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String sql = "insert into suscribe(userId,courseId) values (?,?) ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, suscribe.getUserId());
		query.setParameter(1, suscribe.getCourseId());
		query.executeUpdate();
		session.close();
	}

	@Override
	public void deleteSuscribe(Suscribe suscribe) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String sql = "delete from suscribe where userId = ? and courseId = ?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, suscribe.getUserId());
		query.setParameter(1, suscribe.getCourseId());
		query.executeUpdate();
		session.close();
	}

}
