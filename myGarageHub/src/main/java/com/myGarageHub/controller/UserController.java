package com.myGarageHub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myGarageHub.entity.User;
import com.myGarageHub.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

private final UserService userService;

public UserController(UserService userService) {
	this.userService=userService;
}

@PostMapping("/createUser")
public User createUser(@RequestBody User user) {
	
	return userService.createUser(user);
}

@GetMapping("/getAllUsers")
public List<User> getAllUsers() {
    return userService.getAllUsers();
}

@GetMapping("/getUserById/{id}")
public User getUserById(@PathVariable Long id) {
	return userService.getUserById(id);
}
}
