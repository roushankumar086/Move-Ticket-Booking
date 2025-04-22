package com.example.mtb.serviceImpl;

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
    public UserDetails userRegister(UserDetails userDetails) {
        if (userRepository.existsByEmail(userDetails.getEmail())) {
            throw new EmailAlreadyExistException("user mail already exist " + userDetails.getEmail());
        }

        long now = System.currentTimeMillis(); // current time in milliseconds

        if (userDetails.getRole() == Role.USER) {
            User user = new User();
            user.setUserId(userDetails.getUserId());
            user.setUserName(userDetails.getUserName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setRole(userDetails.getRole());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            user.setDateOfBirth(userDetails.getDateOfBirth());
            user.setCreatedAt(now);
            user.setUpdatedAt(now);
            return userRepository.save(user);
        } else {
            TheaterOwner theaterOwner = new TheaterOwner();
            theaterOwner.setUserId(userDetails.getUserId());
            theaterOwner.setUserName(userDetails.getUserName());
            theaterOwner.setEmail(userDetails.getEmail());
            theaterOwner.setPassword(userDetails.getPassword());
            theaterOwner.setRole(userDetails.getRole());
            theaterOwner.setPhoneNumber(userDetails.getPhoneNumber());
            theaterOwner.setDateOfBirth(userDetails.getDateOfBirth());
            theaterOwner.setCreatedAt(now);
            theaterOwner.setUpdatedAt(now);
            return userRepository.save(theaterOwner);
        }
    }
}
