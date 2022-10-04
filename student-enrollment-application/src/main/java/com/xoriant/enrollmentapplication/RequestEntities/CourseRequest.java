package com.xoriant.enrollmentapplication.RequestEntities;

import java.util.ArrayList;
import java.util.List;

public class CourseRequest {
	
	private int courseId;
	private String courseName;
	
	private List<CollegeRequest> colleges = new ArrayList<>();
	
	public List<CollegeRequest> getColleges() {
		return colleges;
	}
	public void setColleges(List<CollegeRequest> colleges) {
		this.colleges = colleges;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public UserRequest getUserId() {
		return userId;
	}
	public void setUserId(UserRequest userId) {
		this.userId = userId;
	}
	private UserRequest userId;
}
