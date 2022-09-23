package com.xoriant.enrollmentapplication.service;


import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;

public interface UserService {

	public String login(String username, String password);
	public UserResponse register(UserRequest userRequest);
}