package com.xoriant.enrollmentapplication.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.enrollmentapplication.Repository.AddressDao;

import com.xoriant.enrollmentapplication.Repository.StudentMarkDao;
import com.xoriant.enrollmentapplication.Repository.UserDao;
import com.xoriant.enrollmentapplication.RequestEntities.AddressRequest;

import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;
import com.xoriant.enrollmentapplication.ResponseEntities.AddressResponse;

import com.xoriant.enrollmentapplication.ResponseEntities.UserResponse;
import com.xoriant.enrollmentapplication.entities.Address;
import com.xoriant.enrollmentapplication.entities.StudentMarks;
import com.xoriant.enrollmentapplication.entities.User;

@Component
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private StudentMarkDao studentMarkDao;

//	@Override
//	public String login(String email, String password) {
//		String message = "Invalid userName or Password!";
//		User user = userDao.findByEmailId(email);
//		if (user != null) {
//			if (user.getUserPassword().equals(password) && user.getEmailId().equals(email)) {
//				message = "Login Successful";
//			}
//		}
//		return message;
//	}
	@Override
	public UserResponse register(UserRequest userRequest) {

		if (userRequest != null) {
			User userEntity;
			UserResponse userResponse;
			userEntity = getUserEntity(userRequest);
			userEntity = userDao.save(userEntity);
			userResponse = getUserResponse(userEntity);
			return userResponse;
		}
		return null;
	}

	private UserResponse getUserResponse(User userEntity) {

		UserResponse userResponse = new UserResponse();
		StudentMarks studentMarks = new StudentMarks();
		userResponse.setUserId(userEntity.getUserId());
		userResponse.setFirstName(userEntity.getFirstName());
		userResponse.setMiddleName(userEntity.getMiddleName());
		userResponse.setLastName(userEntity.getLastName());
		userResponse.setMobileNumber(userEntity.getMobileNumber());
		userResponse.setEmailId(userEntity.getEmailId());
		studentMarks.setSscMarks(userEntity.getStudentMarks().getSscMarks());
		studentMarks.setMarksId(userEntity.getStudentMarks().getMarksId());
		userResponse.setStudentMarks(studentMarks);
		userResponse.setAddress(getAddressResponse(userEntity.getAddress()));
		return userResponse;
	}

	private List<AddressResponse> getAddressResponse(List<Address> addressResponselist) {
		List<AddressResponse> addresslist = new ArrayList<AddressResponse>();
		
		for (Address address : addressResponselist) {
			AddressResponse addressResponse = new AddressResponse();
			addressResponse.setAddressId(address.getAddressId());
			addressResponse.setCity(address.getCity());
			addressResponse.setState(address.getState());
			addressResponse.setPincode(address.getPincode());
			addresslist.add(addressResponse);
		}
		return addresslist;
	}

	private User getUserEntity(UserRequest userRequest) {

		User userEntity = new User();
		StudentMarks studentmarksEntity = new StudentMarks();
		userEntity.setFirstName(userRequest.getFirstName());
		userEntity.setMiddleName(userRequest.getMiddleName());
		userEntity.setLastName(userRequest.getLastName());
		userEntity.setMobileNumber(userRequest.getMobileNumber());
		userEntity.setAddress(getAddressEntity(userRequest.getAddress()));

		userEntity.setUserPassword(hashPassword(userRequest.getUserPassword()));
		userEntity.setEmailId(userRequest.getEmailId());
		studentmarksEntity.setSscMarks(userRequest.getStudentMarks().getSscMarks());
		userEntity.setStudentMarks(studentmarksEntity);
		return userEntity;
	}

	private List<Address> getAddressEntity(List<AddressRequest> addressRequestlist) {
		List<Address> addresslist = new ArrayList<Address>();
		Address addressEntity = new Address();
		for (AddressRequest address : addressRequestlist) {
			addressEntity.setCity(address.getCity());
			addressEntity.setState(address.getState());
			addressEntity.setPincode(address.getPincode());
			addresslist.add(addressEntity);
		}
		return addresslist;
	}

	public UserResponse update(UserRequest userRequest, int userId) {
		User user = userDao.findById(userId).orElse(null);
		if (user != null) {
			UserResponse userResponse;
			user = getUpdatedUserEntity(userRequest, user);
			userDao.save(user);
			userResponse = getUserResponse(user);
			return userResponse;
		}
		return null;
	}
	

	private User getUpdatedUserEntity(UserRequest userRequest, User user) {

		StudentMarks studentmarksEntity = new StudentMarks();
		user.setFirstName(userRequest.getFirstName());
		user.setMiddleName(userRequest.getMiddleName());
		user.setLastName(userRequest.getLastName());
		user.setMobileNumber(userRequest.getMobileNumber());
		// user.setUserPassword(hashPassword(userRequest.getUserPassword()));
		user.setEmailId(userRequest.getEmailId());
		studentmarksEntity = studentMarkDao.getById(user.getStudentMarks().getMarksId());
		studentmarksEntity.setSscMarks(userRequest.getStudentMarks().getSscMarks());
		user.setStudentMarks(studentmarksEntity);
		/*
		 * addresses = addressDao.findByUserId(user.getUserId()); for (AddressRequest
		 * addressRequest : userRequest.getAddress()) {
		 * addressEntity.setCity(addressRequest.getCity());
		 * addressEntity.setState(addressRequest.getState());
		 * addressEntity.setPincode(addressEntity.getPincode());
		 * addresses.add(addressEntity); } user.setAddress(addresses);
		 */
		return user;
	}

	@Override
	public AddressResponse updateAddress(AddressRequest addressRequest, int userId, int addressId) {
		Address address = addressDao.findById(addressId).orElse(null);
		if (address != null && address.getUserId().getUserId() == userId) {
			AddressResponse addressResponse = new AddressResponse();
			address.setCity(addressRequest.getCity());
			address.setState(addressRequest.getState());
			address.setPincode(addressRequest.getPincode());
			address = addressDao.save(address);
			addressResponse.setCity(address.getCity());
			addressResponse.setState(address.getState());
			addressResponse.setPincode(address.getPincode());
			return addressResponse;
		}
		return null;
	}

	private String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < digest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & digest[i]));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserResponse getUserByEmail(String email) {

		User user = userDao.findByEmailId(email);
		if(user!=null)
		{
			UserResponse userResponse=getUserResponse(user);
			return userResponse;
		}
		return null;
		
	}

	@Override
	public UserResponse updatePassword(int userId, String password) {
		User user = userDao.findById(userId).orElse(null);
		if (user != null) {
			UserResponse userResponse;
			user.setUserPassword(hashPassword(password));
			userDao.save(user);
			userResponse = getUserResponse(user);
			return userResponse;
		}
		return null;
	}

	@Override
	public List<AddressResponse> getUserAddress(int userId) {
		// Address addressEntity = new Address();
		List<Address> addressEntity = new ArrayList<Address>();
		addressEntity = addressDao.findAddressesByUserId(userId);
		List<AddressResponse> addRes = new ArrayList<AddressResponse>();
		addRes = getAddressResponse(addressEntity);

		return addRes;
	}
	//sahad

	
	@Override
	public AddressResponse addAddress(AddressRequest addressRequest, int userId) 
	{
		if(addressRequest!=null) {
			Address addressEntity;
			AddressResponse addressResponse;
			addressEntity=getAddressEntity(addressRequest,userId);
			addressResponse=getAddressResp(addressEntity);
			return addressResponse;
			
			
		}
		return null;
	}
	//sahad
	private Address getAddressEntity(AddressRequest addressRequest,int userId) {
		User user=userDao.getById(userId);
		Address addressEntity=new Address();
		addressEntity.setState(addressRequest.getState());
		addressEntity.setPincode(addressRequest.getPincode());
		addressEntity.setCity(addressRequest.getCity());
		addressEntity.setUserId(user);
		addressDao.save(addressEntity);
		return addressEntity;
	}
	
	private AddressResponse getAddressResp(Address addressEntity) 
	{
		UserResponse userResponse = getUserResponse(addressEntity.getUserId());
		AddressResponse addressResponse=new AddressResponse();
		addressResponse.setState(addressEntity.getState());
		addressResponse.setPincode(addressEntity.getPincode());
		addressResponse.setCity(addressEntity.getCity());
		addressResponse.setUserId(userResponse);
		return addressResponse;
	}

	@Override
	public UserResponse changePassword(String CurrentPassword, String password,int userId ) {
		// TODO Auto-generated method stub
		User user=userDao.getById(userId);
		if(user!=null) {
			
			UserResponse userResponse;
			user.setUserPassword(hashPassword(password));
			userDao.save(user);
			userResponse = getUserResponse(user);
			return userResponse;
			
			}
		return null;
		}
}

