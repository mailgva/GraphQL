package com.gorbatenko.graphql.service;

import com.gorbatenko.graphql.model.Person;
import com.gorbatenko.graphql.model.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonSevice {

    private List<Vehicle> vehicles = List.of(
            new Vehicle(0, "car", "honda", "accord", LocalDate.now()),
            new Vehicle(1, "car", "nissan", "tiida", LocalDate.now()),
            new Vehicle(2, "car", "audi", "r8", LocalDate.now()),
            new Vehicle(3, "car", "toyota", "camry", LocalDate.now())
    );

    private List<Person> persons = List.of(
            new Person("Jhon", List.of("Karl", "Ray"), List.of(vehicles.get(2))),
            new Person("Bill", List.of("Eva", "Jack", "Sara"), List.of(vehicles.get(0)))
    );

    public Person personWithFriend(int personId, int friendId) {
        return new Person(persons.get(personId).getName(),
                List.of(persons.get(personId).getFriends().get(friendId)),
                persons.get(personId).getVehicles());
    }

    public List<Person> persons(int count) {
        return persons;
    }

}
