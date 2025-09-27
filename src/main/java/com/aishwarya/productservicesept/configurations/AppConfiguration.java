package com.aishwarya.productservicesept.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// When you want to have @Beans, then use @Configuration
// When you want to create internal Spring dependencies
@Configuration
public class AppConfiguration {

    // Spring beans are Spring objects which are to be managed by the spring container
    // Spring will run this method for you
    @Bean
    public RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
