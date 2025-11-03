package com.Practice.FeignClient_Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignClientMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientMicroserviceApplication.class, args);
	}

}
