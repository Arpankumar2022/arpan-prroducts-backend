package com.arpanbags.products.arpanbagsbackend.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * STEP -7 
 * This is basically used to  exception message But in Spring Boot 3.0 we have ProblemDetail Class 
 *  which helps to work httpStatus and errorMessage 
 * 
 * @author Arpan
 *
 */
@Getter
@AllArgsConstructor
public class APIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private HttpStatus status;
	
	private String message;

}
