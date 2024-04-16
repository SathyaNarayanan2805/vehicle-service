package com.example.Vehicle.service;

import com.example.Vehicle.model.Vehicle;
import com.example.Vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicle(final Long id) {
    return vehicleRepository.findById(id)
            .orElseThrow( () -> new IllegalArgumentException("Vehicle not found with id: "+id));
    }

    public  Vehicle saveVehicle(final Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public Vehicle updateVehicle(final Vehicle vehicle) {
        Vehicle oldVehicle = vehicleRepository.findById(vehicle.getId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found with id: "+vehicle.getId()));
        oldVehicle.setMake(vehicle.getMake());
        oldVehicle.setModel(vehicle.getModel());
        oldVehicle.setYear(vehicle.getYear());
        oldVehicle.setVin(vehicle.getVin());

        return vehicleRepository.save(oldVehicle);
    }

    public void deleteVehicle(final Long id){
        vehicleRepository.deleteById(id);
    }
}
