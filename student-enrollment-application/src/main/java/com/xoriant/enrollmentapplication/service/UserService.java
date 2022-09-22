package com.xoriant.enrollmentapplication.service;

import java.util.List;

import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;
import com.xoriant.enrollmentapplication.entities.User;

public interface UserService {

	public List<User> findAllUsers();
	public UserResponse register(UserRequest userRequest);
}