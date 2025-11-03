package com.Practice.SpringSecurity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository_Interface userRepo;
	@Autowired
	private UserService userService;
	
	/*public UserController(UserRepository_Interface userRepo) {
		this.userRepo = userRepo;
	} */
	
	/*@GetMapping("/AllUsersList")
	public List<UserEntity> currentUsers(@RequestBody UserEntity user) {
		return userRepo.findAll();
		
	}*/
	
	public UserController(UserRepository_Interface userRepo, UserService userService) {
		this.userRepo = userRepo;
		this.userService = userService;
	}

	@PostMapping("/register")
	public UserEntity registerUser(@RequestBody UserEntity user) {
	    return userService.registerUser(user);
	}

	@PostMapping("/login")
	public String userLogin(@RequestBody UserEntity user) {
	    var u = userRepo.findByUsername(user.getUsername());
	    if (u != null)
	        return "User Login success";
	    return "User is not Registered";
	}

	
}
