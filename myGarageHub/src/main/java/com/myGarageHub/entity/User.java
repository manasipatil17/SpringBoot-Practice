package com.myGarageHub.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;
private String name;
private String email;

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
private List<Vehicle> vehicles;

public User(long id, String name, String email, List<Vehicle> vehicles) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.vehicles = vehicles;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public List<Vehicle> getVehicles() {
	return vehicles;
}

public void setVehicles(List<Vehicle> vehicles) {
	this.vehicles = vehicles;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
}



}
