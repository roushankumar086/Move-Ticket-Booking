package com.example.mtb.controller;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.service.UserService;
import com.example.mtb.utility.ResponseStructure;
import com.example.mtb.utility.StructureResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StructureResponseBuilder structureResponseBuilder;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
        UserResponse userDetails1 = userService.userRegister(userRegistrationRequest);

        return structureResponseBuilder.success(HttpStatus.CREATED,"user registeration succssefully done",userDetails1);
    }

    @PutMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@RequestBody UserRequest userRequest, @PathVariable String email){
        UserResponse userResponse=userService.updateUser(userRequest,email);
        return structureResponseBuilder.success(HttpStatus.CREATED,"user updated succssefully ",userResponse);
    }


//    @DeleteMapping("/users/{email}")
//    public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable String email) {
//        userService.softDeleteUser(email);
//        return structureResponseBuilder.success(HttpStatus.OK, "User deleted successfully", "Deleted: " + email);
//    }

    @DeleteMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponse>> deleteUser(@RequestParam String email) {
        UserResponse userResponse = userService.softDeleteUser(email);
        return structureResponseBuilder.success(HttpStatus.OK, "User account soft deleted successfully" ,userResponse);
                
    }






}