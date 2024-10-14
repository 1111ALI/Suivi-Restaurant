package com.almo.restaurant.config;

import com.almo.restaurant.entity.Person;
import com.almo.restaurant.enums.PersonRole;
import com.almo.restaurant.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setUsername("ali");
        person.setEmail("ali@gmail.com");
        person.setPassword(passwordEncoder.encode("12345678"));
        person.setRoles(Set.of(PersonRole.ADMIN, PersonRole.USER));
        person.setIsactivated(true);
        personRepository.save(person);
    }

}
