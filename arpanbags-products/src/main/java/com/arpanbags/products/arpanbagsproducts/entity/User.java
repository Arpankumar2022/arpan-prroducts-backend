package com.arpanbags.products.arpanbagsproducts.entity;

import com.arpanbags.products.arpanbagsproducts.dto.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String mobileNumber;

    private String password;
    private String address;

    private String companyName;

    private List<Role> roles;

    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters and setters

    public enum Status {
        ACTIVE, INACTIVE
    }
}
