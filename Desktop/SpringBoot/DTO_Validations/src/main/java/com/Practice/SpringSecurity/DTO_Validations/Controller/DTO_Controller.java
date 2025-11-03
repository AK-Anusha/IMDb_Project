package com.Practice.SpringSecurity.DTO_Validations.Controller;
import com.Practice.SpringSecurity.DTO_Validations.DTO_ControllerAdvice.DTO_User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class DTO_Controller {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody DTO_User user) {
        System.out.println("✅ Received user: " + user.getUsername());
        return ResponseEntity.ok("✅ User registered successfully: " + user.getUsername());
    }
    
    
}
