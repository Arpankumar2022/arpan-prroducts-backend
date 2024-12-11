package com.arpanbags.arpanbagsconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ArpanbagsConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArpanbagsConfigserverApplication.class, args);
	}

}
