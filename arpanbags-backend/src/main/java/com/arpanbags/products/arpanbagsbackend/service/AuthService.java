package com.arpanbags.products.arpanbagsbackend.service;

import com.arpanbags.products.arpanbagsbackend.dto.AuthResponse;
import com.arpanbags.products.arpanbagsbackend.dto.LoginDTO;
import com.arpanbags.products.arpanbagsbackend.dto.RegisterDTO;

public interface AuthService {
	
	String register(RegisterDTO registerDTO);
	
	AuthResponse login(LoginDTO loginDTO);

}
