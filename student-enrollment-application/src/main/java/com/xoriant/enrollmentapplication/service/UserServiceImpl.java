package com.xoriant.enrollmentapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.enrollmentapplication.Repository.UserDao;
import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;
import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;
import com.xoriant.enrollmentapplication.entities.Address;
import com.xoriant.enrollmentapplication.entities.StudentMarks;
import com.xoriant.enrollmentapplication.entities.User;

@Component
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String login(String email, String password) 
	{
		String message = "Invalid userName or Password!";
	    User user = userDao.findByEmailId(email);
		if (user!=null) {
			if (user.getUserPassword().equals(password) && user.getEmailId().equals(email)) {
				message="Login Successful";
			}
		}
		return message;
	}

	@Override
	public UserResponse register(UserRequest userRequest) 
	{
		if(userRequest!=null)
		{   
			User userEntity;
			UserResponse userResponse;
			userEntity = getUserEntity(userRequest);
			userDao.save(userEntity);
			userResponse = getUserResponse(userEntity);
			return userResponse;
		}
		return null;
	}
	private UserResponse getUserResponse(User userEntity) {
		
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(userEntity.getUserId());
		userResponse.setFirstName(userEntity.getFirstName());
		userResponse.setMiddleName(userEntity.getMiddleName());
		userResponse.setLastName(userEntity.getLastName());
		userResponse.setEmailId(userEntity.getEmailId());
		return userResponse;
	}
	private User getUserEntity(UserRequest userRequest) {
		
		User userEntity = new User();
		userEntity.setFirstName(userRequest.getFirstName());
		userEntity.setMiddleName(userRequest.getMiddleName());
		userEntity.setLastName(userRequest.getLastName());
		userEntity.setMobileNumber(userRequest.getMobileNumber());
		userEntity.setAddress(getAddressEntity(userRequest.getAddress()));
		userEntity.setUserPassword(userRequest.getUserPassword());
		userEntity.setEmailId(userRequest.getEmailId());
		StudentMarks studentmarksEntity = new StudentMarks();
		studentmarksEntity.setSscMarks(userRequest.getStudentMarks().getSscMarks());;
		userEntity.setStudentMarks(studentmarksEntity);
		return userEntity;
	}
	private List<Address> getAddressEntity(List<AddressRequest> addressRequestlist) {
		List<Address> addresslist= new ArrayList<Address>();
		Address addressEntity = new Address();
		for (AddressRequest address : addressRequestlist) 
		{
			addressEntity.setCity(address.getCity());
			addressEntity.setState(address.getState());
			addressEntity.setPincode(address.getPincode());
			addresslist.add(addressEntity);
		}
		return addresslist;
	}
}
