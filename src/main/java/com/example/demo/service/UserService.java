package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	public void addUser(User user);
	
	public void updateUser(User user) ;
	
	public void deleteUser(int userId);
	
	public List<User> listUserByType(int type,int offset,int limit);
	
	public User login(String name,String password);
}
