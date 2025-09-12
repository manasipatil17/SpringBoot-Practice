package com.myGarageHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myGarageHub.entity.Vehicle;

public interface VehicleRepositry extends JpaRepository<Vehicle, Long> {

}