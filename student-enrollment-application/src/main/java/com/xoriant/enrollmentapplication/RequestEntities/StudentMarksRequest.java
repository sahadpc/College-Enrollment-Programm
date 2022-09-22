package com.xoriant.enrollmentapplication.RequestEntities;


import com.xoriant.enrollmentapplication.entities.User;

public class StudentMarksRequest {
	
	private int marksId;
	private User userId;
	private double sscMarks;
	
	public int getMarksId() {
		return marksId;
	}
	public void setMarksId(int marksId) {
		this.marksId = marksId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public double getSscMarks() {
		return sscMarks;
	}
	public void setSscMarks(double sscMarks) {
		this.sscMarks = sscMarks;
	}
	
	
}
