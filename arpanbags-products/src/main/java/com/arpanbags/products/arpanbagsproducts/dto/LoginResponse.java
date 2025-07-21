package com.arpanbags.products.arpanbagsproducts.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
    private String token;
    private String fullName;
    private List<String> roles;

    // Getters and Setters
}
