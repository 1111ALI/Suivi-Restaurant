package com.almo.restaurant.service.serviceImpl;

import com.almo.restaurant.dto.PersonDto;
import com.almo.restaurant.entity.Person;
import com.almo.restaurant.repository.PersonRepository;
import com.almo.restaurant.service.serviceInterf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServiceInterf {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

//    @Override
//    public Person create(Person person) {
//        return personRepository.save(person);
//    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Map<String, String> createPerson(PersonDto personDto) {
        Map<String,String> response=new HashMap<>();
            Person person =new Person();
                person.setUsername(personDto.getUsername());
                person.setEmail(personDto.getEmail());
                person.setPassword(passwordEncoder.encode(personDto.getPassword()));
                person.setRoles(personDto.getRoles());
                person.setActivationCode(personDto.getActivationCode());

                personRepository.save(person);

                return response;
    }
}
