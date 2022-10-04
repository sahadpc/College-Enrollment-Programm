package com.xoriant.enrollmentapplication.ResponseEntities;

import java.util.ArrayList;
import java.util.List;

import com.xoriant.enrollmentapplication.entities.StudentMarks;

public class UserResponse {
	
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private long mobileNumber;
	private String emailId;
	private String userPassword;
	private StudentMarks studentMarks;
	private List<AddressResponse> address = new ArrayList<>();
	private List<CourseResponse> courseResponses = new ArrayList<>();
	
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
	public List<CourseResponse> getCourseResponses() {
		return courseResponses;
	}
	public void setCourseResponses(List<CourseResponse> courseResponses) {
		this.courseResponses = courseResponses;
	}

}
