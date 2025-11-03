package com.Practice.UserService_Microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// URL points to OrderService (provider)
@FeignClient(name = "order-service", url = "http://localhost:8081")
public interface OrderClient {

    @GetMapping("/order/details")
    String getOrderDetails();
}