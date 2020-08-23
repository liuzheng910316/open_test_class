package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.dao.SuscribeDao;
import com.example.demo.model.Suscribe;
import com.example.demo.service.SuscribeService;

@Service
public class SuscribeServiceImpl implements SuscribeService{
	@Autowired
	SuscribeDao suscribeDao;
	@Autowired
	CourseDao courseDao;
	public void addSuscribe(Suscribe suscribe){
		suscribeDao.addSuscribe(suscribe);
		courseDao.addStudentNum(suscribe.getCourseId());
	}
	public void deleteSuscribe(Suscribe suscribe){
		suscribeDao.deleteSuscribe(suscribe);
		courseDao.minusStudentNum(suscribe.getCourseId());
	}
}
