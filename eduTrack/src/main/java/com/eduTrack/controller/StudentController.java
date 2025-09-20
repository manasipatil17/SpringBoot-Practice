package com.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduTrack.entities.Student;
import com.eduTrack.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable long id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@RequestBody Student s,@PathVariable Long id) {
		return studentService.updateStudent(s, id);
	}
}
