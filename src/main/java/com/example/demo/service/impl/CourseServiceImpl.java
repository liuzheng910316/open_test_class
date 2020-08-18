package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.model.Course;

@Service
public class CourseServiceImpl {
	@Autowired
	CourseDao courseDao;
	public void addCourse(Course course){
		courseDao.addCourse(course);
	}
	public void updateCourse(Course course){
		courseDao.updateCourse(course);
	}
	public void deleteCourse(int courseId){
		courseDao.deleteCourse(courseId);
	}
	public List<Course> list(int offset,int limit){
		return courseDao.list(offset, limit);
	}
	public void updateStudentNum(int courseId){
		
	}
}
