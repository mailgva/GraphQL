package com.gorbatenko.graphql.controller.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gorbatenko.graphql.model.Person;
import com.gorbatenko.graphql.model.Vehicle;
import com.gorbatenko.graphql.service.PersonSevice;
import com.gorbatenko.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonQuery implements GraphQLQueryResolver {
    @Autowired
    private PersonSevice personSevice;

    public Person personWithFriend(int personId, int friendId) {
        return personSevice.personWithFriend(personId, friendId);
    }

    public List<Person> persons(int count) {
        return personSevice.persons(count);
    }
}
