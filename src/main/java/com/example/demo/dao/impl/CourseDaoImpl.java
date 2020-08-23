package com.example.demo.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;
@Repository
public class CourseDaoImpl implements CourseDao{
	private static String ADD_SYUDENT_NUM_SQL = "update course set num = num + 1 where id = ?";
	private static String MINUS_SYUDENT_NUM_SQL = "update course set num = num - 1 where id = ?";

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
		Session session = sessionFactory.openSession();
		String sql = "update course set name = ? where id = ? ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, course.getName());
		query.setParameter(1, course.getId());
		query.executeUpdate();
		session.close();
	}

	@Override
	public void deleteCourse(int courseId) {
		Session session = sessionFactory.openSession();
		String sql = "delete from course where id = ? ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, courseId);
		query.executeUpdate();
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
	public void addStudentNum(int courseId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(ADD_SYUDENT_NUM_SQL);
		query.setParameter(0, courseId);
		query.executeUpdate();
		session.close();
	}
	@Override
	public void minusStudentNum(int courseId) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(MINUS_SYUDENT_NUM_SQL);
		query.setParameter(0, courseId);
		query.executeUpdate();
		session.close();
	}

}
