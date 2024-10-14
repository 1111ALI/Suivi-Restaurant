package com.almo.restaurant.controllers.api;

import com.almo.restaurant.dto.PersonDto;
import com.almo.restaurant.entity.Person;
import com.almo.restaurant.service.serviceInterf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonServiceInterf personServiceInterf;


   @PostMapping("/createPerson")
   public Map<String, String> createPerson(@RequestBody PersonDto personDto){
       return personServiceInterf.createPerson(personDto);
    }
//    @PostMapping("/newPerson")
//    public Person create(@RequestBody Person person) {
//
//        return personServiceInterf.create(person);
//    }

    @GetMapping("/allPerson")
    public List<Person> getAllPerson(){

        return personServiceInterf.getAllPerson();
    }

}
