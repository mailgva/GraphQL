package com.gorbatenko.graphql.controller.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gorbatenko.graphql.model.Vehicle;
import com.gorbatenko.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {
    @Autowired
    private VehicleService vehicleService;
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }
    public List<Vehicle> vehicleByModelCode(final String modelCode) {
        return this.vehicleService.vehicleByModelCode(modelCode);
    }
}
