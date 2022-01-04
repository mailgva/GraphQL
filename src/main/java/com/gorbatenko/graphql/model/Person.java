package com.gorbatenko.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private List<String> friends;
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Vehicle> vehicles(int count) {
        return vehicles.stream().limit(count).collect(Collectors.toList());
    }



}
