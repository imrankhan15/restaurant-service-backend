package com.restaurantbackend.restaurantservices.guest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GuestConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
