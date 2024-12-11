package com.arpanbags.products.arpanbagsbackend.dto;

import java.util.Set;

import com.arpanbags.products.arpanbagsbackend.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * 
 * STEP -6 Now we need to register the user for login 
 * purpose hence we need to sue register DTO and hence we will create here.
 * 
 * @author Arpan 
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
	
	
	private String name;
	private String userName;
	private String email;
	private String password;
	private String roles;
	private String mobNum;

}
