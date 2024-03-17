package com.cgi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String passwordConfirm;
}
