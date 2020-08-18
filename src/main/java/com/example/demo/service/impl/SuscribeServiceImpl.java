package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SuscribeDao;
import com.example.demo.model.Suscribe;

@Service
public class SuscribeServiceImpl {
	@Autowired
	SuscribeDao suscribeDao;
	public void addSuscribe(Suscribe suscribe){
		suscribeDao.addSuscribe(suscribe);
	}
	public void deleteSuscribe(int id){
		suscribeDao.deleteSuscribe(id);
	}
}
