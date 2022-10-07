package com.xoriant.enrollmentapplication.ResponseEntities;

import java.util.ArrayList;
import java.util.List;

import com.xoriant.enrollmentapplication.entities.Course;



public class CollegeResponse {

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	private int collegeId;
	private String collegeName;
	
	private List<Course> courses = new ArrayList<Course>();
}
