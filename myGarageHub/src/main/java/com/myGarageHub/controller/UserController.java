package com.myGarageHub.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myGarageHub.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

private final UserService userService;


}
