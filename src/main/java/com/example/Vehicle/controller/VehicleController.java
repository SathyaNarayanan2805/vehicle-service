package com.example.Vehicle.controller;

import com.example.Vehicle.model.Vehicle;
import com.example.Vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/get/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/get/vehicle/{id}")
    public Vehicle getAllVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping("/save/vehicle")
    public Vehicle saveVehicle(@RequestBody final Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @PutMapping("update/vehicle")
    public Vehicle updateVehicle(@RequestBody final Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/delete/vehicle/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "Success";
    }

}
