package com.example.demo.dao.impl;

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
		session.save(suscribe);
		session.close();
	}

	@Override
	public void deleteSuscribe(int suscribeId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.delete(suscribeId);
		session.close();
	}

}
