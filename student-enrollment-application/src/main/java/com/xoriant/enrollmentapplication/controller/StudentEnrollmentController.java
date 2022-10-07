package com.xoriant.enrollmentapplication.controller;

<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e

import java.util.ArrayList;
import java.util.List;


=======
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
<<<<<<< HEAD
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
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
<<<<<<< HEAD
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======

>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======
=======

>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
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
	
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
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
		

=======
<<<<<<< HEAD
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
=======
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
}

