package com.arpanbags.products.arpanbagsproducts.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class Msg91OtpService {

    @Value("${msg91.authkey}")
    private String authKey;

    @Value("${msg91.sender}")
    private String sender;

    @Value("${msg91.otp_template_id}")
    private String otpTemplateId;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendOtp(String mobileNumber, String otp) {
        String formattedNumber = "+91" + mobileNumber;

        String url = "https://control.msg91.com/api/v5/otp";

        Map<String, String> body = new HashMap<>();
        body.put("template_id", otpTemplateId);
        body.put("mobile", formattedNumber);
        body.put("authkey", authKey);
        body.put("otp", otp);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to send OTP via MSG91: " + response.getBody());
        }
    }
}
