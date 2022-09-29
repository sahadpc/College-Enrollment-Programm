package com.xoriant.enrollmentapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;
import com.xoriant.enrollmentapplication.entities.User;
import com.xoriant.enrollmentapplication.service.UserService;

@RestController
@RequestMapping("/api")
public class StudentEnrollmentResource {

	@Autowired
	private UserService userService; 
	
	@GetMapping("/login")
	public String Login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		return userService.login(email,password);
	}
	
	@PostMapping("/register")
	public UserResponse Register(@RequestBody UserRequest userRequest)
	{
		return userService.register(userRequest);
	}
}
