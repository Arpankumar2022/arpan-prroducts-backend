package com.arpanbags.products.arpanbagsbackend.dto;

import java.util.Set;

import com.arpanbags.products.arpanbagsbackend.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse { 

	private String accessToken;
	
	private String tokenType = "Bearer";
	
	private Set<Role> roles;
}
