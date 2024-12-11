package com.arpanbags.products.arpanbagsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Arpan Bags Products API", version = "3.0", description = "Arpan Bags Products Information"))
public class ArpanbagsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArpanbagsBackendApplication.class, args);
	}
	
	
}
