package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Transactional
	public void addUser(User user){
		userDao.addUser(user);
	}
	

	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public void deleteUser(int userId){
		userDao.deleteUser(userId);
	}
	
	public List<User> listUserByType(int type,int offset,int limit){
		return userDao.listUserByType(type, offset, limit);
	}
	
	public User login(String email,String password){
		return userDao.login(email, password);
	}
}
