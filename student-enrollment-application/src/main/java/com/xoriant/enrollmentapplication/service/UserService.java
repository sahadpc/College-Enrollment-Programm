package com.xoriant.enrollmentapplication.service;

import java.util.List;

import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.AddressResponse;
import com.xoriant.enrollmentapplication.ResponseEntities.CollegeResponse;
import com.xoriant.enrollmentapplication.ResponseEntities.CourseResponse;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;

public interface UserService {

	//public String login(String username, String password);

	public UserResponse register(UserRequest userRequest);

	public UserResponse update(UserRequest userRequest, int userId);

	public AddressResponse updateAddress(AddressRequest addressRequest, int userId, int addressId);
	
	public UserResponse getUserByEmail(String email);

	public UserResponse updatePassword(int userId, String password);

	public List<CourseResponse> getCoursesByUserId(int userId);

	public List<CollegeResponse> getCollegesByCourseId(int courseId);
}