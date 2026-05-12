package com.empCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empCrud.entity.Employee;
import com.empCrud.service.EmpService;

@RestController
@RequestMapping("/Employee")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@PostMapping("/createEmp")
	public Employee saveEmp(@RequestBody Employee emp) {
		return service.saveEmp(emp);
	}
	
	@GetMapping("/getEmpById/{id}")
	public Employee findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
    @DeleteMapping("/deleteById/{id}")
	public String DeleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
    
    @PutMapping("/updateEmp/{id}")
    public Employee updateEmp(@PathVariable Long id, @RequestBody Employee Emp) {
    	return service.updateEmp(id, Emp);
    }
    
    @GetMapping("/findAllEmp")
    public List<Employee> findAllEmp(){
    	return service.findAllEmp();
    }
}
