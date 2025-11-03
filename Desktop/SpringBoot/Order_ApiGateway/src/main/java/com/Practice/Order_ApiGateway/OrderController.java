package com.Practice.Order_ApiGateway;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/view")
    public String viewOrders() {
        return "Orders: [Order1: Phone, Order2: Laptop]";
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody String item) {
        return "Order Created for: " + item;
    }
}
