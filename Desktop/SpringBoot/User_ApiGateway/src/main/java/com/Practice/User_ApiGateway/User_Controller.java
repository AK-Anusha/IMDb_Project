package com.Practice.User_ApiGateway;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class User_Controller {

    @GetMapping("/info")
    public String getUserInfo() {
        return "User Info: Name - Anusha, Role - User";
    }

    @GetMapping("/admin")
    public String getAdminInfo() {
        return "Admin Info: You have admin privileges!";
    }
}
