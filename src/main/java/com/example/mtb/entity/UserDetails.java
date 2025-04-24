package com.example.mtb.entity;

import com.example.mtb.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(length = 10)
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Long createdAt, updatedAt,deleteAt;

    private boolean isDeleted = false;

}
