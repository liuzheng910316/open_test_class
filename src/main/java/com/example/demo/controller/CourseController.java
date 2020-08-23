package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.impl.CourseServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value="/course")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="/add")
	public void addCourse(@ModelAttribute Course course,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.addCourse(course);
		resp.getWriter().print("create course success");
	}
	
	@RequestMapping(value="/update")
	public void updateCourse(@ModelAttribute Course course,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.updateCourse(course);
		resp.getWriter().print("update course success");
	}
	
	@RequestMapping(value="/delete")
	public void deleteCourse(int courseId,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.deleteCourse(courseId);
		resp.getWriter().print("delete cource success");
	}
	
	@RequestMapping(value="/list")
	public void list(int offset,int limit,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.list(offset, limit);
		resp.getWriter().print("serach success");
	}
}
