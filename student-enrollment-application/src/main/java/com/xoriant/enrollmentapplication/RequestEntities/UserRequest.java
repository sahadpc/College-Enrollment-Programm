package com.xoriant.enrollmentapplication.RequestEntities;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


public class UserRequest {
	
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private long mobileNumber;
	private String emailId;
	private String userPassword;
	private StudentMarksRequest studentMarks;
	
	private List<AddressRequest> address = new ArrayList<>();

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e
	public List<AddressRequest> getAddress() {
		return address;
	}
	public void setAddress(List<AddressRequest> address) {
		this.address = address;
	}
	
	public StudentMarksRequest getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(StudentMarksRequest studentMarks) {
		this.studentMarks = studentMarks;
	}
>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public StudentMarksRequest getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(StudentMarksRequest studentMarks) {
		this.studentMarks = studentMarks;
	}

	public List<AddressRequest> getAddress() {
		return address;
	}

	public void setAddress(List<AddressRequest> address) {
		this.address = address;
	}
}
