package com.arpanbags.accounts.arpanbagsaccounts;

import com.arpanbags.accounts.arpanbagsaccounts.dto.AccountMessageInfoDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableConfigurationProperties(value={AccountMessageInfoDTO.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ArpanbagsAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArpanbagsAccountsApplication.class, args);
	}

}
