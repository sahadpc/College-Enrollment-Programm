package com.xoriant.enrollmentapplication.service;

import java.util.List;

import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.AddressResponse;
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======

>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;

public interface UserService {

	//public String login(String username, String password);

	public UserResponse register(UserRequest userRequest);

	public UserResponse update(UserRequest userRequest, int userId);

	public AddressResponse updateAddress(AddressRequest addressRequest, int userId, int addressId);
	
	public UserResponse getUserByEmail(String email);

	
	public List<AddressResponse> getUserAddress(int userId);
	
	//public AddressResponse addAddress(AddressRequest addressRequest,int userId);


	public UserResponse updatePassword(int userId, String password);
	public AddressResponse addAddress(AddressRequest addressRequest, int userId);
	
	public UserResponse changePassword(String CurrentPassword, String password,int userId);

}