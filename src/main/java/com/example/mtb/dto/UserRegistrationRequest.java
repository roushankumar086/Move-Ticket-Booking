package com.example.mtb.dto;

import com.example.mtb.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRegistrationRequest(

        @NotNull(message = "Username cannot be null")
        @NotBlank(message = "Username is mandatory")
        @Size(min = 3, max = 20, message = "Username must be 3 to 20 characters long")
        String userName,

        @Email(message = "Email should be valid")
        String email,

        @Size(min = 8, message = "Password must be at least 8 characters")
        String password,

        @NotNull(message = "Role is required")
        Role role,

        @NotNull(message = "Phone number is required")
        String phoneNumber,

        @NotNull(message = "Date of Birth is required")
        LocalDate dateOfBirth
                                      ) {

}
