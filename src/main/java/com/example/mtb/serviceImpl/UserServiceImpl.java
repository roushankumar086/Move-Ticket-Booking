package com.example.mtb.serviceImpl;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.Role;
import com.example.mtb.exception.EmailAlreadyExistException;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails userRegister(UserRegistrationRequest userRegistrationRequest) {
        if (userRepository.existsByEmail(userRegistrationRequest.email())) {
            throw new EmailAlreadyExistException("user mail already exist " + userRegistrationRequest.email());
        }

        long now = System.currentTimeMillis(); // current time in milliseconds

        if (userRegistrationRequest.role() == Role.USER) {
            User user = new User();
            user.setUserId(user.getUserId());
            user.setUserName(userRegistrationRequest.userName());
            user.setEmail(userRegistrationRequest.email());
            user.setPassword(userRegistrationRequest.password());
            user.setRole(userRegistrationRequest.role());
            user.setPhoneNumber(userRegistrationRequest.phoneNumber());

            user.setDateOfBirth(userRegistrationRequest.dateOfBirth());
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            return userRepository.save(user);
        } else {
            TheaterOwner theaterOwner = new TheaterOwner();
            theaterOwner.setUserId(theaterOwner.getUserId());
            theaterOwner.setUserName(userRegistrationRequest.userName());
            theaterOwner.setEmail(userRegistrationRequest.email());
            theaterOwner.setPassword(userRegistrationRequest.password());
            theaterOwner.setRole(userRegistrationRequest.role());
            theaterOwner.setPhoneNumber(userRegistrationRequest.phoneNumber());
            theaterOwner.setDateOfBirth(userRegistrationRequest.dateOfBirth());
            theaterOwner.setCreatedAt(now);
            theaterOwner.setUpdatedAt(now);
            return userRepository.save(theaterOwner);
        }
    }
}
