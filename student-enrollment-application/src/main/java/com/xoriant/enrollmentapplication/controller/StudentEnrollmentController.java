package com.xoriant.enrollmentapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.AddressResponse;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;
import com.xoriant.enrollmentapplication.service.UserService;

@RestController
@RequestMapping("/api")
public class StudentEnrollmentController {

	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/login") public String login(@RequestParam("email") String
	 * email, @RequestParam("password") String password) { return
	 * userService.login(email, password); }
	 */

	@PostMapping("/register")
	public UserResponse register(@RequestBody UserRequest userRequest) {
		return userService.register(userRequest);
	}

	@PutMapping("/update")
	public UserResponse update(@RequestBody UserRequest userRequest, @RequestParam("userId") int userId) {
		return userService.update(userRequest, userId);
	}

	@PutMapping("/updateaddress")
	public AddressResponse updateAddress(@RequestBody AddressRequest addressRequest, @RequestParam("userId") int userId,
			@RequestParam("addressId") int addressId) {
		return userService.updateAddress(addressRequest, userId, addressId);
	}
}
