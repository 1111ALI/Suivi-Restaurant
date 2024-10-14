package com.almo.restaurant.service.serviceInterf;

import com.almo.restaurant.dto.PersonDto;
import com.almo.restaurant.entity.Person;

import java.util.List;
import java.util.Map;

public interface PersonServiceInterf {
//    Person create(Person person);

    List<Person> getAllPerson();

    Map<String, String> createPerson(PersonDto personDto);
}
