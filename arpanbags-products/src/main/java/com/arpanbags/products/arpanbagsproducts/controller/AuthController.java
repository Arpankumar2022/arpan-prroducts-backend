package com.arpanbags.products.arpanbagsproducts.controller;

import com.arpanbags.products.arpanbagsproducts.dto.OtpVerifyRequest;
import com.arpanbags.products.arpanbagsproducts.dto.RegisterRequest;
import com.arpanbags.products.arpanbagsproducts.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Registered successfully. OTP sent for verification.");
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String mobileNumber) {
        authService.sendOtp(mobileNumber);
        return ResponseEntity.ok("OTP sent.");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpVerifyRequest request) {
        String result = authService.verifyOtp(request);
        return ResponseEntity.ok(result);
    }
}
