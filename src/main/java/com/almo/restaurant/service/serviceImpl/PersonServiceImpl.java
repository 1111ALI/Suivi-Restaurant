package com.almo.restaurant.service.serviceImpl;

import com.almo.restaurant.repository.PersonRepository;
import com.almo.restaurant.service.serviceInterf.PersonServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonServiceInterf {
    private final PersonRepository personRepository;
}
