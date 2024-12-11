package com.arpanbags.products.arpanbagsbackend.exception;

public class JWTExpiredException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public JWTExpiredException(String msg) {
		super(msg);
	}

}

