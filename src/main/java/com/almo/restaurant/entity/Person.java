package com.almo.restaurant.entity;

import com.almo.restaurant.enums.PersonRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "persons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long personId;
    private String username;
    private String password;
    private String passwordConfirmation;
    private UUID activationCode;
    private UUID resetCode;
    private String email;
    private Set<PersonRole> roles;
    private boolean isactivated;
}
