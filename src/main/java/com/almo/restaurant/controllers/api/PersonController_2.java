package com.almo.restaurant.controllers.api;

import com.almo.restaurant.entity.Person;
import com.almo.restaurant.repository.PersonRepository;
import com.almo.restaurant.service.serviceInterf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/user/")
//public class PersonController_2 {
//    private final PersonServiceInterf personServiceInterf;
//    private final PersonRepository personRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @PostMapping
//    public void registerPerson(Person person){
//        if( !person.getPassword().equals(person.getPasswordConfirmation())){
//            throw new RuntimeException("Les deux mots de passe ne sont pas identiques");
//        }
//        person.setPassword(passwordEncoder.encode(person.getPassword()));
//        person.setIsactivated(false);
//        person.setActivationCode(UUID.randomUUID());
//        personRepository.save(person);
//
//    }
//}
