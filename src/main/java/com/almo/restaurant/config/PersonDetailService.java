package com.almo.restaurant.config;

import com.almo.restaurant.entity.Person;
import com.almo.restaurant.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonDetailService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository. findByEmail(username);

        if ( person == null){
            throw new UsernameNotFoundException("utilisateur introuvable dans la BD ! ");
        }
        return new User(person.getUsername(), person.getPassword(),
                person.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.name()))
                        .collect(Collectors.toSet())
                );
    }
}
