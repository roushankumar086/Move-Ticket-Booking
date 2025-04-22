package com.example.mtb.service;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Service;


public interface UserService {
    public UserDetails userRegister(UserRegistrationRequest userRegistrationRequest);
}
