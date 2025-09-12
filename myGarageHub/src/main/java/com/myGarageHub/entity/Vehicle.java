package com.myGarageHub.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String number;
private String model;

@ManyToOne
@JoinColumn(name= "user_id")
private User user;

@OneToMany(mappedBy = "vehicle", cascade=CascadeType.ALL)
private List<ServiceBooking> serviceBookings;

public Vehicle() {
	super();
	// TODO Auto-generated constructor stub
}

public Vehicle(long id, String number, String model, User user, List<ServiceBooking> serviceBookings) {
	super();
	this.id = id;
	this.number = number;
	this.model = model;
	this.user = user;
	this.serviceBookings = serviceBookings;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<ServiceBooking> getServiceBookings() {
	return serviceBookings;
}

public void setServiceBookings(List<ServiceBooking> serviceBookings) {
	this.serviceBookings = serviceBookings;
}

@Override
public String toString() {
	return "Vehicle [id=" + id + ", number=" + number + ", model=" + model + ", user=" + user + "]";
}


}
