package com.arpanbags.products.arpanbagsbackend;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TestDemo {
	
	public static void main(String[] args) {
		
		
		
		
		System.out.println(LocalDateTime.now());
		
		long minutes =	TimeUnit.MILLISECONDS.toMinutes(2500001);
		System.out.println(LocalDateTime.now().plusMinutes(minutes));
		
	}

}
	