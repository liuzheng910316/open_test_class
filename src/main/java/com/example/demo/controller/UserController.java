package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.CourseService;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	CourseService courseService;
	@RequestMapping(value="/addStudent")
	public void addStudent(User user,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		user.setType(1);
		userService.addUser(user);
		resp.getWriter().print("create student success");
	}
	@RequestMapping(value="/addTeacher")
	public void addTeacher(User user,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		user.setType(2);
		userService.addUser(user);
		resp.getWriter().print("create teacher success");
	}
	
	@RequestMapping(value="/update")
	public void updateUser(@ModelAttribute User user,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.updateUser(user);
		resp.getWriter().print("update success");
	}
	
	@RequestMapping(value="/delete")
	public void deleteUser(int id,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.deleteUser(id);
		resp.getWriter().print("delete success");
	}
	
	@RequestMapping(value="/login")
	public void login(String name,String password,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = userService.login(name, password);
		if (user == null) {
			resp.getWriter().print("email or password is incorrect");
		}
		//admin
		
		if (user.getType()==0) {
			String printText = "<html> ";
			printText = printText + "add student<br/><form action='addStudent' method='get'>";
			printText = printText + "name:<input type='text' name='name' /><br>";
			printText = printText + "password:<input type='password' name='password' /><br>";
			printText = printText + "<input type='submit' value='addstudent'></form>";
			printText = printText + "add teacher<br/><form action='addTeacher' method='get'>";
			printText = printText + "name:<input type='text' name='name'/><br>";
			printText = printText + "password:<input type='password' name='password' /><br>";
			printText = printText + "<input type='submit' value='addteacher'></form>";
										
			List<User> students = userService.listUserByType(1, 0, 10);
			if (students != null && students.size()>0) {
				printText = printText + "students detail <table border='1'> <tr><th>name</th><th>email</th><th>delete</th><th>update</th></tr>";
				for (User student:students) {
					printText = printText + "<tr><th>"+student.getName()+"</th><th>"+student.getEmail()+"</th>";
					printText = printText +"<th><a href = '/user/delete?id="+student.getId()+"' >delete</a></th>";					
					printText = printText +"<th><form action='update' method='get'>name:<input type='text' name='name' /><input type='hidden' name='id' value='"+student.getId()+"'/><input type='submit' value='update'></form></th></tr>";	
				}
				printText = printText + "</table>";
			}
			List<User> teachers = userService.listUserByType(2, 0, 10);
			if (teachers != null && teachers.size()>0) {
				printText = printText + "teachers detail <table border='1'> <tr><th>name</th><th>email</th><th>delete</th><th>update</th></tr>";
				for (User teacher:teachers) {
					printText = printText + "<tr><th>"+teacher.getName()+"</th><th>"+teacher.getEmail()+"</th>";
					printText = printText +"<th><a href = '/user/delete?id="+teacher.getId()+"' >delete</a></th>";					
					printText = printText +"<th><form action='update' method='get'>name:<input type='text' name='name' /><input type='hidden' name='id' value='"+teacher.getId()+"'/><input type='submit' value='update'></form></th></tr>";	
				}
				printText = printText + "</table>";
			}
			printText = printText + "</html>";
			resp.getWriter().print(printText);
		}
		if (user.getType() == 1) {
			String printText = "<html> ";
			List<Course> courses = courseService.list(0, 10);
			if (courses != null && courses.size()>0) {
				printText = printText + "course detail <table border='1'> <tr><th>name</th><th>num</th><th>suscribe</th><th>unsuscribe</th></tr>";
				for (Course course:courses) {
					printText = printText + "<tr><th>"+course.getName()+"</th><th>"+course.getNum()+"</th>";
					printText = printText +"<th><a href = '/suscribe/add?courseId="+course.getId()+"&userId="+user.getId()+"' >suscribe</a></th>";
					printText = printText +"<th><a href = '/suscribe/delete?courseId="+course.getId()+"&userId="+user.getId()+"' >unsuscribe</a></th></tr>";
				}
				printText = printText + "</table>";
			}
			printText = printText + "</html>";
			resp.getWriter().print(printText);
		}
		if (user.getType() == 2) {
			String printText = "<html> ";
			printText = printText + "add student<br/><form action='/course/add' method='get'>";
			printText = printText + "name:<input type='text' name='name' /><br>";
			printText = printText + "<input type='submit' value='addcourse'></form><br/>";
			List<Course> courses = courseService.list(0, 10);
			if (courses != null && courses.size()>0) {
				printText = printText + "course detail <table border='1'> <tr><th>name</th><th>num</th><th>delete</th><th>update</th></tr>";
				for (Course course:courses) {
					printText = printText + "<tr><th>"+course.getName()+"</th><th>"+course.getNum()+"</th>";
					printText = printText +"<th><a href = '/course/delete?courseId="+course.getId()+"' >delete</a></th>";
					printText = printText +"<th><form action='/course/update' method='get'>name:<input type='text' name='name' /><input type='hidden' name='id' value='"+course.getId()+"'/><input type='submit' value='update'></form></th></tr>";	
				}
				printText = printText + "</table>";
			}
			printText = printText + "</html>";
			resp.getWriter().print(printText);
		}
	}
	
	@RequestMapping(value="/listByType")
	public void listByType(int type,int offset,int limit,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.listUserByType(type, offset, limit);
		resp.getWriter().print("search success");
	}

}
