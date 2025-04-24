package com.example.mtb.mapper;

import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import org.springframework.stereotype.Component;


@Component
    public class UserMapper {
    long now = System.currentTimeMillis();
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

        public UserDetails toUpdateUserDetails(UserRequest userRequest,UserDetails userDetails){
            userDetails.setUserName(userRequest.userName());
            userDetails.setPhoneNumber(userRequest.phoneNumber());
            userDetails.setDateOfBirth(userRequest.dateOfBirth());
            userDetails.setUpdatedAt(now);
            return userDetails;
        }

    public UserDetails toDeleteUserDetails(UserDetails user) {

        user.setDeleted(true);
        user.setDeleteAt(now);
        return user;
    }
}


