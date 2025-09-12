package com.myGarageHub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myGarageHub.entity.Vehicle;
import com.myGarageHub.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepo;

    public VehicleService(VehicleRepository vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepo.findById(id).orElse(null);
    }
}
