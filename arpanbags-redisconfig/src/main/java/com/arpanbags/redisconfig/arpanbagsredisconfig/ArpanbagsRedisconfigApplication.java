package com.arpanbags.redisconfig.arpanbagsredisconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArpanbagsRedisconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArpanbagsRedisconfigApplication.class, args);
	}

}
