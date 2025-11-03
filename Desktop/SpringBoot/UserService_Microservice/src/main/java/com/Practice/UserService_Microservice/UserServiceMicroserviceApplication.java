package com.Practice.UserService_Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class UserServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceMicroserviceApplication.class, args);
	}

	// bean for Rest Template
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
