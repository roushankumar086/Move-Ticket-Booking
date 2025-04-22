package com.example.mtb.mapper;

import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;


@Component
    public class UserMapper {
        public UserResponse toResponse(UserDetails user) {
            return new UserResponse(
                    user.getUserId(),
                    user.getUserName(),
                    user.getEmail(),
                    user.getRole(),
                    user.getPhoneNumber(),
                    user.getDateOfBirth()
            );
        }
    }


