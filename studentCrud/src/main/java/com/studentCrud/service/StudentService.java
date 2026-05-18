package com.studentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentCrud.entity.Student;
import com.studentCrud.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired   
	StudentRepository repo;
    
    public Student saveStudent(Student s) {
    	Student s1 = new Student();
    	s1.setName(s.getName());
    	s1.setCity(s.getCity());
    	return repo.save(s1);
    }
    
    public Student findStudentById(Long id) {	
    	return repo.findById(id).orElseThrow(()-> new RuntimeException("Id not found.."));
    }
    
    public List<Student> getAllStudents(){
    	return repo.findAll();
    }
    
    public String deleteStudent(Long id) {
    	repo.deleteById(id);
    	return "Student deleted successfully..";
    }
    
    public Student updateStudent(Student s, Long id) {
    	Student s1 = repo.findById(id).orElseThrow(()-> new RuntimeException("id not found.."));
    	s1.setName(s.getName());
    	s1.setCity(s.getCity());
    	return repo.save(s1);
    }
}
