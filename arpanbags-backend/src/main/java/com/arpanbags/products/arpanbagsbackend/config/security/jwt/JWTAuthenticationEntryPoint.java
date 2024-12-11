package com.arpanbags.products.arpanbagsbackend.config.security.jwt;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


  

@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint{

	
	/**
	 *  STEP -13 
	 *  
	 *  This below commence()  method is called or used when an unauthorized user is trying to access the resource 
	 *  that requires the authentication.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
		
		
	}

}
