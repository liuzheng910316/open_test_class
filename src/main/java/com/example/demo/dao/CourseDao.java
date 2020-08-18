package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseDao {
	public void addCourse(Course course);
	public void updateCourse(Course course);
	public void deleteCourse(int courseId);
	public List<Course> list(int offset,int limit);
	public void updateStudentNum(int courseId);
}
