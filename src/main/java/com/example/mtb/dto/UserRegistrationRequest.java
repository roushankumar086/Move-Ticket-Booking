package com.example.mtb.dto;

import com.example.mtb.enums.Role;

import java.time.LocalDate;

public record UserRegistrationRequest(String userName,
                                      String email,
                                      String phoneNumber,
                                      String password,
                                      Role role,
                                      LocalDate dateOfBirth
                                      ) {

    @Override
    public String userName() {
        return userName;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String phoneNumber() {
        return phoneNumber;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public LocalDate dateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public Role role() {
        return role;
    }
}
