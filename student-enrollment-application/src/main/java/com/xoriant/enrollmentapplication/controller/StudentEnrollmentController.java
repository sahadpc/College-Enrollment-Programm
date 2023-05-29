package com.xoriant.enrollmentapplication.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.xoriant.enrollmentapplication.Repository.UserDao;
import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.AddressResponse;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;
import com.xoriant.enrollmentapplication.service.EmailService;
import com.xoriant.enrollmentapplication.service.UserService;

import net.bytebuddy.utility.RandomString;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class StudentEnrollmentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService mailService;

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
	

	@GetMapping("/getaddress")
	public List<AddressResponse> getAddress(@RequestParam("userId") int userId){
		List<AddressResponse> addressResponse=new ArrayList<AddressResponse>();
		addressResponse=userService.getUserAddress(userId);
		if(addressResponse!=null) {
			return addressResponse;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
	}
	@GetMapping("/forgetPassword")
	public UserResponse resetPassword(@RequestParam("email") String email) {
		UserResponse userResponse = new UserResponse();
		userResponse = userService.getUserByEmail(email);
		if(userResponse != null) {
			String password = RandomString.make(8);
			int userId = userResponse.getUserId();
			userResponse = userService.updatePassword(userId,password);
			mailService.sendMail(email, "Reset password Link", "Use this password to login:" + password);
			return userResponse;
		}
	    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email id not found!!!");
	}

	@PostMapping("/addAddress")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AddressResponse  addAddress(@RequestBody AddressRequest addressRequest,@RequestParam("userId") int userId) {
		
		AddressResponse addressResponse=new AddressResponse();
		addressResponse=userService.addAddress(addressRequest, userId);
		if(addressResponse!=null) {
		
			return addressResponse;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		
		
	}
	
	@GetMapping("/changePassword")
	public UserResponse changePassword(@RequestParam("CurrentPassword") String CurrentPassword,@RequestParam("password") String password,@RequestParam("userId") int userId ) {
		UserResponse userResponse=userService.changePassword(CurrentPassword, password,userId);
		return userResponse;
		
	}
	
	@GetMapping("/deleteAddress")
	public boolean deleteAddress(@RequestParam("userId") int userId,
			@RequestParam("addressId") int addressId) {
		boolean returns=userService.deleteAddress(userId,addressId);
		return returns;
	}
	
	
		
//	@GetMapping("/getCoursesByUserId")
//	public List<CourseResponse> getCoursesbyUserId(@RequestParam("userId") int userId) {
//		List<CourseResponse> courseResponses = new ArrayList<CourseResponse>();
//		courseResponses = userService.getCoursesByUserId(userId);
//		return courseResponses;
//	}
//	
//	@GetMapping("/getCollegesByCourseId")
//	public List<CollegeResponse> getCollegesByCourseId(@RequestParam("courseId") int courseId){
//		List<CollegeResponse> collegeResponses = new ArrayList<CollegeResponse>();
//		collegeResponses = userService.getCollegesByCourseId(courseId);
//		return null;
//		
//	}
	
	
}

