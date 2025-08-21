package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		String msg=service.deleteData(id);
		return msg;
	}
	
	@PutMapping("/updateRecord/{id}")
	public String updateData( @RequestBody Student s,@PathVariable int id) {
		String msg= service.updateData(s, id);
		return msg;
	}
}
