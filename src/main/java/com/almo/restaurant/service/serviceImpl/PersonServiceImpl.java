package com.almo.restaurant.service.serviceImpl;

import com.almo.restaurant.entity.Person;
import com.almo.restaurant.repository.PersonRepository;
import com.almo.restaurant.service.serviceInterf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServiceInterf {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Person create(Person person) {
        passwordEncoder.encode(person.getPassword());
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {

        return personRepository.findAll();
    }
}
