package com.Practice.Admin_EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@org.springframework.cloud.client.discovery.EnableDiscoveryClient
public class AdminEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminEurekaServerApplication.class, args);
	}

}
