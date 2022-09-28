package com.xoriant.enrollmentapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserResponse register(@RequestBody UserRequest userRequest) {
		UserResponse userRequestGetByEmail = new UserResponse();
		userRequestGetByEmail = userService.getUserByEmail(userRequest.getEmailId());
		if (userRequestGetByEmail == null) {
			return userService.register(userRequest);
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "EmailId already exists!!!");
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

	@GetMapping("/getbyemail")
	public UserResponse getUserByEmail(@RequestParam("email") String email) {
		UserResponse userResponse=new UserResponse();
		userResponse=userService.getUserByEmail(email);
		if (userResponse!=null) {
			return userResponse;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email id not found!!!");
	}
}
