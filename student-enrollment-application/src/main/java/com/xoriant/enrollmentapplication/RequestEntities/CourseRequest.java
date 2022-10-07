package com.xoriant.enrollmentapplication.RequestEntities;

import java.util.ArrayList;
import java.util.List;

import com.xoriant.enrollmentapplication.entities.College;
import com.xoriant.enrollmentapplication.entities.User;

import lombok.Getter;
import lombok.Setter;


public class CourseRequest {
	
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<College> getColleges() {
		return colleges;
	}
	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}
	private int courseId;
	private String courseName;
	
	List<User> users = new ArrayList<User>();
	List<College> colleges = new ArrayList<College>();
	
}
