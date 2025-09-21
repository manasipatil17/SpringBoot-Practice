package com.eduTrack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@DeleteMapping("/deleteByUsername/{username}")
	public String deleteUserById(@PathVariable String username) {
		return service.deleteUserByUsername(username);
	}
	
	@PutMapping("/updateUser/{username}")
	public User updateUser(@RequestBody User user,@PathVariable String username) {
		return service.updateUser(user, username);
	}
	
	@GetMapping("/getUserByUsername/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return service.getUserByUsername(username);

	}

	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	
	@GetMapping("getAllAdmins")
	public List<User> getAllAdmins() {
		return service.getAllAdmins();
	}

}
