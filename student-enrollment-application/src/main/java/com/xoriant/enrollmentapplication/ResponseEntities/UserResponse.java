package com.xoriant.enrollmentapplication.ResponseEntities;

import java.util.ArrayList;
import java.util.List;

import com.xoriant.enrollmentapplication.entities.StudentMarks;




public class UserResponse {
	
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
<<<<<<< HEAD
=======
	private long mobileNumber;
	private String emailId;
	private String userPassword;
	private StudentMarks studentMarks;
	private List<AddressResponse> address = new ArrayList<>();
	
	public List<AddressResponse> getAddress() {
		return address;
	}
	public void setAddress(List<AddressResponse> address) {
		this.address = address;
	}
	public StudentMarks getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(StudentMarks studentMarks) {
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
<<<<<<< HEAD

=======
<<<<<<< HEAD
	public StudentMarks getStudentMarks() {
		return studentMarks;
	}
	public void setStudentMarks(StudentMarks studentMarks) {
		this.studentMarks = studentMarks;
	}
	public List<AddressResponse> getAddress() {
		return address;
	}
	public void setAddress(List<AddressResponse> address) {
		this.address = address;
	}
	private long mobileNumber;
	private String emailId;
	private String userPassword;
	private StudentMarks studentMarks;
	private List<AddressResponse> address = new ArrayList<>();
=======
>>>>>>> 6cf8274cf11a794b19d34221c69c944ecfcac65e


>>>>>>> 372f855fd7f8a0b45697dc5a441b2833ac574ead
}
