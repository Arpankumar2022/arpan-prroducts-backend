package com.arpanbags.products.arpanbagsbackend.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class GlobalExceptionalHandler extends ResponseEntityExceptionHandler{
	
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorDetails>  handlerAPIException(APIException exception, WebRequest webRequest){

		ErrorDetails errorDetails = new ErrorDetails(
				LocalDateTime.now(), 
				exception.getMessage(), 
				webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}

}


/**
 * ---What is the Java Transaction API (JTA)?
 *   
 * The Java Transaction API (JTA) is one of the APIs defined in the Java Enterprise Edition (Java EE) platform, 
 * specifically providing a framework for handling distributed transactions in a consistent and reliable manner.
 *  JTA allows applications to perform coordinated transactions across multiple resource systems, 
 *  like databases, message queues, or other transactional resources.

    JTA’s importance cannot be understated, especially in environments 
    where multiple distributed systems need to interact and share data. 
    It ensures that if a part of the transaction fails, the entire operation is rolled back,
    keeping the system state consistent.
 * * 
 * 
 * It works on the principle of ACID property 
 * A-  Automicity
 * C - Consistency
 * I-  Isolation
 * D-  Durable 
 * 
 * 
 *  S -- Single Responsibilty 
 *  O -- Open Closed 
 *  L -- Liskov Substitution Principle
 *  I -- Interface Segragation 
 *  D -- Dependency Injection 
 * 
 */
