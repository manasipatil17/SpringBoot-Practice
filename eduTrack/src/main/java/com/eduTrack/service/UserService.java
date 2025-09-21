package com.eduTrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduTrack.dao.UserDao;
import com.eduTrack.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public User registerUser(User user) {
		return dao.registerUser(user);
	}
	
	public String deleteUserByUsername(String username) {
		return dao.deleteUserById(username);
	}
	
	public User updateUser(User user, String username) {
		return dao.updateUser(user, username);
	}
	
	public User getUserByUsername(String username) {
	return dao.getUserByUsername(username);
	}
	
	public List<User> getAllUser() {
		return dao.getAllUser();
	}
	
	public List<User> getAllAdmins() {
		return dao.getAllAdmins();
	}
}
