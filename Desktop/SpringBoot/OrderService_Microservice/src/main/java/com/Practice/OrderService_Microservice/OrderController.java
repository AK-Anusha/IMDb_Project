package com.Practice.OrderService_Microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order/details")
    public String getOrderDetails() {
    	
        return "Order#123 - iPhone 15 - Delivered";
    }
}
