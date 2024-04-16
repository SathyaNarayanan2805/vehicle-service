package com.example.Vehicle.service;

import com.example.Vehicle.model.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    Vehicle getVehicle(Long id);

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);
}
