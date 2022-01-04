package com.gorbatenko.graphql.service;

import com.gorbatenko.graphql.model.Vehicle;
import com.gorbatenko.graphql.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private List<Vehicle> vehicles = List.of(
            new Vehicle(0, "car", "honda", "accord", LocalDate.now()),
            new Vehicle(1, "car", "nissan", "tiida", LocalDate.now()),
            new Vehicle(2, "car", "audi", "r8", LocalDate.now()),
            new Vehicle(3, "car", "toyota", "camry", LocalDate.now())
    );

    private final VehicleRepository vehicleRepository ;
    public VehicleService(final VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository ;
    }
    @Transactional
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
    }
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }
    @Transactional
    public Boolean deleteVehicle(final int id) {
        this.vehicleRepository.deleteById(id);
        return true;
    }
    public Vehicle updateVehicles(final int id, final String type, final String modelCode) {
        Vehicle vehicle = this.vehicleRepository.findById(id).get();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        return this.vehicleRepository.save(vehicle);
    }

    public List<Vehicle> vehicleByModelCode(String modelCode) {
        return vehicles.stream().filter(vehicle -> vehicle.getModelCode().equals(modelCode)).collect(Collectors.toList());
    }
}