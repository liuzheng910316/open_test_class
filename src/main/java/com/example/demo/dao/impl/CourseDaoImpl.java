package com.example.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
@Repository
public class CourseDaoImpl implements CourseDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(course);
		session.close();
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.update(course);
		session.close();
	}

	@Override
	public void deleteCourse(int courseId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.delete(courseId);
		session.close();
	}

	@Override
	public List<Course> list(int offset, int limit) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Course.class);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(limit);
		List<Course> list = criteria.list();
		session.close();
		return list;
	}

	@Override
	public void updateStudentNum(int courseId) {
		// TODO Auto-generated method stub
		
	}

}
