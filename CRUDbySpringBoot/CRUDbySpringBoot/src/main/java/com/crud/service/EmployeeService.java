package com.crud.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.crud.dao.EmployeeDao;
import com.crud.entity.Employee;

@Service
public class EmployeeService {

	EmployeeDao dao;
	public String insertData(Employee e) {
	String msg=dao.insertData(e);
	
	if(Objects.isNull(e)) {
		msg="Data is not iserted";
	}
		return msg;
	}
}
