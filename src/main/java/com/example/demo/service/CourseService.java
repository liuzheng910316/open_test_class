package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;

public interface CourseService {
	public void addCourse(Course course);
	public void updateCourse(Course course);
	public void deleteCourse(int courseId);
	public List<Course> list(int offset,int limit);
}
