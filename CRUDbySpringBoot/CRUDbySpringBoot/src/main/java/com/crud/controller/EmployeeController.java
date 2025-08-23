package com.crud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/EmployeeInfo")
public class EmployeeController {

	EmployeeService service;
	
	@PostMapping("/insertRecord")
	public String insertData(@RequestBody Employee e) {
		String msg= service.insertData(e);
		
		return msg;
	}
}
