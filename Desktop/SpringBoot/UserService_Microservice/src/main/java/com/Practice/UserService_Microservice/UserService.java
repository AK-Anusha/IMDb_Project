package com.Practice.UserService_Microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private OrderClient orderClient;

    public String getUserOrderDetails() {
        String orderDetails = orderClient.getOrderDetails();
        return "User: Anusha | " + orderDetails;
    }
}
