package com.arpanbags.products.arpanbagsproducts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String mobileNumber;

    private String password;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters and setters

    public enum Status {
        ACTIVE, INACTIVE
    }
}
