package com.empCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empCrud.entity.Employee;
import com.empCrud.repository.EmpRepository;

@Service
public class EmpService {
    
	@Autowired
	private EmpRepository repo;
	
	public Employee saveEmp(Employee emp) {
		Employee emp1 = new Employee();
		emp1.setName(emp.getName());
		emp1.setSalary(emp.getSalary());
		
		return repo.save(emp1);
	}
	
	public Employee findById(Long id) {
		return repo.findById(id).orElseThrow(()-> new RuntimeException("Employee not found !!"));
	}
	
	public String deleteById(Long id) {
		repo.deleteById(id);
		return "Employee deleted successfully";
	}
	
	public Employee updateEmp(Long id, Employee emp) {
		Employee existingEmp = repo.findById(id).orElseThrow(()-> new RuntimeException("Employee with this id not fount !!"));
		existingEmp.setName(emp.getName());
		existingEmp.setSalary(emp.getSalary());
		return repo.save(existingEmp); 
	}
	
	public List<Employee> findAllEmp(){
		return repo.findAll();
	}
}
