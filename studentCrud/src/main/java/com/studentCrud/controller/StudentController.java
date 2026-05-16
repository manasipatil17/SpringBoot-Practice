package com.studentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentCrud.entity.Student;
import com.studentCrud.service.StudentService;

@RestController()
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    
	@Autowired
	StudentService service;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student s) {
		return service.saveStudent(s);
	}
	
	@GetMapping("/findStudentById/{id}")
	public Student findStudentById(@PathVariable Long id){
		return service.findStudentById(id);
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return service.getAllStudents();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return service.deleteStudent(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student s,@PathVariable Long id) {
		return service.updateStudent(s, id);
	}
}
