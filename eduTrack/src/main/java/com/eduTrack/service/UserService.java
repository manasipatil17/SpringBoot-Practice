package com.eduTrack.service;

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
}
