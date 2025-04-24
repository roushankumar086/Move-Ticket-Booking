package com.example.mtb.service;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Service;


public interface UserService {
    public UserResponse userRegister(UserRegistrationRequest userRegistrationRequest);

    UserResponse updateUser(UserRequest userRequest, String email);

    UserResponse softDeleteUser(String email);


}
