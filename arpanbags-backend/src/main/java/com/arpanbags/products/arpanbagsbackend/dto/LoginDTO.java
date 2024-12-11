package com.arpanbags.products.arpanbagsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * 
 * STEP - 12 ,
 *  We can create this DTO after STEP-6 as well but firstly we created 
 * RegisterDTO and Doing all registration steps we can do this CREATION of LoginDTO api.
 * 
 * 
 * @author Arpan Kumar
 *
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
	
	private String userNameOrEmail;
	private String password;

}
