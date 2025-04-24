package com.example.mtb.dto;

import java.time.LocalDate;

public record UserRequest(String userName, String phoneNumber, LocalDate dateOfBirth) {
}
