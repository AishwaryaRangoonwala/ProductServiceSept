package com.aishwarya.productservicesept.commons;

import com.aishwarya.productservicesept.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {

    private RestTemplate restTemplate;

    public AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean validateToken(String tokenValue) {
        System.out.println("Came here---------------------->");
        System.out.println("tokenValue---------------------->" + tokenValue);
        UserDto userDto = null;
        try {
            ResponseEntity<UserDto> response=
                    restTemplate.getForEntity(
                            "http://localhost:8080/user/validate/" + tokenValue,
                            UserDto.class
                    );
            userDto = response.getBody();
        } catch (Exception e) {
            return false;
        }

        return userDto != null;
    }
}
