package com.arpanbags.users.arpanbagsusers.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${product-api-base-uri}")
    private String productApiBaseURI;

   /* @Autowired
    private HttpServletRequest request;*/

   /* public String getCurrentRequestToken() {
        return request.getHeader("Authorization");
    }*/

    @Bean
    public RestClient restClient() {
        System.out.println(productApiBaseURI);
        return RestClient.create(productApiBaseURI);
    }
}
