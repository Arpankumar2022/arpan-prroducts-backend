package com.arpanbags.accounts.arpanbagsaccounts.dto;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="accounts")
public record AccountMessageInfoDTO(String message) {
}
