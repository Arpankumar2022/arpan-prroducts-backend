package com.arpanbags.products.arpanbagsproducts.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OtpVerifyRequest {
    private String mobileNumber;
    private String otp;
}
