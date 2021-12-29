package com.gorbatenko.graphql.controller.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gorbatenko.graphql.model.Vehicle;
import com.gorbatenko.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
    @Autowired
    private VehicleService vehicleService;
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }

    public Boolean deleteVehicle(final int id) {
        return this.vehicleService.deleteVehicle(id);
    }

    public Vehicle updateVehicle(final int id, final String type, final String modelCode) {
        return this.vehicleService.updateVehicles(id, type, modelCode);
    }
}
