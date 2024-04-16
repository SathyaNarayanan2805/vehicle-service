package com.example.Vehicle.controller;

import com.example.Vehicle.model.Vehicle;
import com.example.Vehicle.repository.VehicleRepository;
import com.example.Vehicle.service.VehicleService;
import com.example.Vehicle.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {

    private VehicleService vehicleService;

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

    /*@GetMapping("/put/vehicle")
    public Vehicle saveVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setMake("Bugatti");
        vehicle.setModel("v8");
        vehicle.setVin("Vin");
        vehicle.setYear(2023);
        return vehicleService.saveVehicle(vehicle);
    }*/

}
