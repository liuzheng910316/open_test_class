package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value="/add")
	public void addUser(@ModelAttribute User user,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.addUser(user);
		resp.getWriter().print("创建用户成功");
	}
	
	@RequestMapping(value="/update")
	public void updateUser(@ModelAttribute User user,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.updateUser(user);
		resp.getWriter().print("更新用户成功");
	}
	
	@RequestMapping(value="/delete")
	public void deleteUser(int userId,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.deleteUser(userId);;
		resp.getWriter().print("删除用户成功");
	}
	@RequestMapping(value="/login")
	public void login(String email,String password,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.login(email, password);
		resp.getWriter().print("登录成功");
	}
	@RequestMapping(value="/listByType")
	public void listByType(int type,int offset,int limit,
			HttpServletRequest req,HttpServletResponse resp) throws Exception{
		userService.listUserByType(type, offset, limit);
		resp.getWriter().print("查询成功");
	}
}
