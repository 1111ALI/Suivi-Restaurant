package com.almo.restaurant.dto;

import com.almo.restaurant.enums.PersonRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonDto {

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
