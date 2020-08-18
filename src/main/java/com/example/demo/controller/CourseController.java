package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.impl.CourseServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping(value="/course")
public class CourseController {
	@Autowired
	CourseServiceImpl courseService;
	
	@RequestMapping(value="/add")
	public void addCourse(@ModelAttribute Course course,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.addCourse(course);
		resp.getWriter().print("创建成功");
	}
	
	@RequestMapping(value="/update")
	public void updateCourse(@ModelAttribute Course course,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.updateCourse(course);
		resp.getWriter().print("更新成功");
	}
	
	@RequestMapping(value="/delete")
	public void deleteCourse(int courseId,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.deleteCourse(courseId);
		resp.getWriter().print("删除成功");
	}
	@RequestMapping(value="/list")
	public void list(int offset,int limit,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		courseService.list(offset, limit);
		resp.getWriter().print("查询成功");
	}
}
