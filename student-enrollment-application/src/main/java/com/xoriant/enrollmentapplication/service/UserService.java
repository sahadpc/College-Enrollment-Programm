package com.xoriant.enrollmentapplication.service;

import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.AddressResponse;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;

public interface UserService {

	public String login(String username, String password);

	public UserResponse register(UserRequest userRequest);

	public UserResponse update(UserRequest userRequest, int userId);

	public AddressResponse updateAddress(AddressRequest addressRequest, int userId, int addressId);
}