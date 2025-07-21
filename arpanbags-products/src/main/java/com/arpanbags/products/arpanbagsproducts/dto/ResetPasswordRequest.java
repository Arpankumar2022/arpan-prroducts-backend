package com.arpanbags.products.arpanbagsproducts.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResetPasswordRequest {
    private String mobileNumber;
    private String newPassword;

    // Getter and Setter
}
