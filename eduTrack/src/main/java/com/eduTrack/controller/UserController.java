package com.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduTrack.entities.User;
import com.eduTrack.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/registerUser")
	public ResponseEntity<Integer> registerUser(@RequestBody User user) {
		User registerUser = service.registerUser(user);
		if (registerUser != null) {
			return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Integer>(3, HttpStatus.OK);
		}
	}

}
