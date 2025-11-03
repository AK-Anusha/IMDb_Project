package com.Practice.UserService_Microservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/order")
    public String getUserOrder() {
        return userService.getUserOrderDetails();
    }
}

