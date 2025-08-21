package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController
public class StudentController {
    
	@Autowired
	StudentService service;
	
	@PostMapping("/saveData")
	public String insertData(@RequestBody Student s) {
		String msg=service.insertData(s);
		return msg;
	}
}
