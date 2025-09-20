package com.eduTrack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduTrack.dao.StudentDao;
import com.eduTrack.entities.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	public Student createStudent(Student student) {
		return dao.createStudent(student);
	}
	
	public String deleteStudent(long id) {
		return dao.deleteStudent(id);
	}
	
	public Student getStudentById(long id) {
		return dao.getStudentById(id);
	}
	
	public String updateStudent(Student s, long id) {
		return dao.updateData(s, id);
	}
	
	public List<Student> getAllStudents(){
		return dao.getAllStudents();
	}
}
