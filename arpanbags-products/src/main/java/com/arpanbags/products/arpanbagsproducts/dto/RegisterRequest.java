package com.arpanbags.products.arpanbagsproducts.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String email;
    private String mobileNumber;
    private String fullName;
}
