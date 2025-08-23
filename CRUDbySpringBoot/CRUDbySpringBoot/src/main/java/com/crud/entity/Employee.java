package com.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
private int e_id;
private String name;
private String city;
public Employee(int e_id, String name, String city) {
	super();
	this.e_id = e_id;
	this.name = name;
	this.city = city;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public int getE_id() {
	return e_id;
}
public void setE_id(int e_id) {
	this.e_id = e_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "Employee [e_id=" + e_id + ", name=" + name + ", city=" + city + "]";
}


}
