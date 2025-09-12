package com.myGarageHub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myGarageHub.entity.Vehicle;
import com.myGarageHub.repository.VehicleRepository;

@RestController
	@RequestMapping("/vehicles")
	public class VehicleController {
	    private final VehicleRepository vehicleRepo;

	    public VehicleController(VehicleRepository vehicleRepo) {
	        this.vehicleRepo = vehicleRepo;
	    }

	    @PostMapping("/createVehicle")
	    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
	        return vehicleRepo.save(vehicle);
	    }

	    @GetMapping("/getAllVehicle")
	    public List<Vehicle> getAllVehicles() {
	        return vehicleRepo.findAll();
	    }
	}


