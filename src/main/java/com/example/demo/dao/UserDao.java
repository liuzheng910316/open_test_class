
package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

public interface UserDao{
	public void addUser(User user);
	public void updateUser(User user);
	public User login(String email,String password);
	public void deleteUser(int userId);
	public List<User> listUserByType(int type,int offset,int limit);
}