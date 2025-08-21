package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.StudentDao;
import com.crud.entity.Student;

@Service
public class StudentService {
    
	@Autowired
	StudentDao  dao;
	public String insertData(Student s) {
		
		String msg = dao.insertData(s);
		
		return msg;
	}
}
