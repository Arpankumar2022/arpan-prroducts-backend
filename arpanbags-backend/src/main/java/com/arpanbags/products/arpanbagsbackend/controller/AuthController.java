package com.arpanbags.products.arpanbagsbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpanbags.products.arpanbagsbackend.dto.AuthResponse;
import com.arpanbags.products.arpanbagsbackend.dto.LoginDTO;
import com.arpanbags.products.arpanbagsbackend.dto.RegisterDTO;
import com.arpanbags.products.arpanbagsbackend.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class AuthController {
	
	/**
	 * 
	 * STEP -10 
	 * To create register and sign in API for user details from POSTMAN 
	 * 
	 * 
	 */
	private AuthService authService;
	
	// Build create register API 
	
	@PostMapping("/register")
	public ResponseEntity<String>  register(@RequestBody RegisterDTO registerDTO){
		String response =  authService.register(registerDTO);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	/**
	 * STEP - 12 ,
     * We can create this Login API  after STEP-6 as well but firstly we created 
     * RegisterDTO and Doing all registration steps we can do this CREATION of LoginDTO api.
	 */
	@PostMapping("/login")
	public ResponseEntity<AuthResponse>  login(@RequestBody LoginDTO loginDTO){
		AuthResponse authResponse =  authService.login(loginDTO);
		return new ResponseEntity<>(authResponse, HttpStatus.OK);
	}
	
	

}
