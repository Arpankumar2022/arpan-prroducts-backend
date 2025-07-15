package com.arpanbags.products.arpanbagsproducts.service;

import com.arpanbags.products.arpanbagsproducts.dto.OtpVerifyRequest;
import com.arpanbags.products.arpanbagsproducts.dto.RegisterRequest;
import com.arpanbags.products.arpanbagsproducts.entity.User;
import com.arpanbags.products.arpanbagsproducts.entity.UserOtp;
import com.arpanbags.products.arpanbagsproducts.repository.UserOtpRepository;
import com.arpanbags.products.arpanbagsproducts.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserOtpRepository userOtpRepository;
    private final Msg91OtpService msg91OtpService;

    public AuthService(UserRepository userRepository, UserOtpRepository userOtpRepository, Msg91OtpService msg91OtpService) {
        this.userRepository = userRepository;
        this.userOtpRepository = userOtpRepository;
        this.msg91OtpService = msg91OtpService;
    }

    public void register(RegisterRequest request) {
        if (userRepository.findByMobileNumber(request.getMobileNumber()).isPresent()) {
            throw new RuntimeException("Mobile number already registered");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setFullName(request.getFullName());
        user.setStatus(User.Status.INACTIVE);
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        sendOtp(request.getMobileNumber());
    }

    public void sendOtp(String mobileNumber) {
        User user = userRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getStatus() != User.Status.ACTIVE) {
            throw new RuntimeException("User is not active");
        }

        String otp = String.format("%06d", new SecureRandom().nextInt(999999));

        UserOtp userOtp = new UserOtp();
        userOtp.setUser(user);
        userOtp.setOtp(otp);
        userOtp.setExpiresAt(LocalDateTime.now().plusMinutes(5));
        userOtpRepository.save(userOtp);

        msg91OtpService.sendOtp(mobileNumber, otp);
    }

    public String verifyOtp(OtpVerifyRequest request) {
        User user = userRepository.findByMobileNumber(request.getMobileNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserOtp userOtp = userOtpRepository
                .findTopByUserAndOtpAndIsUsedFalseOrderByCreatedAtDesc(user, request.getOtp())
                .orElseThrow(() -> new RuntimeException("Invalid OTP"));

        if (userOtp.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("OTP expired");
        }

        userOtp.setUsed(true);
        userOtpRepository.save(userOtp);

        if (user.getStatus() == User.Status.INACTIVE) {
            user.setStatus(User.Status.ACTIVE);
            userRepository.save(user);
        }

        return "OTP verified. Login successful.";
    }
}
