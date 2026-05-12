package com.empCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empCrud.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>{

}
