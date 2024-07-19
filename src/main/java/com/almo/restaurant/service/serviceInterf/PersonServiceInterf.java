package com.almo.restaurant.service.serviceInterf;

import com.almo.restaurant.entity.Person;

import java.util.List;

public interface PersonServiceInterf {
    Person create(Person person);

    List<Person> getAllPerson();
}
