package com.xoriant.enrollmentapplication.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity(name = "course")

public class Course {
	
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

	@Id
	private int courseId;
	private String courseName;
	
	@ManyToMany(mappedBy = "courses")
	List<User> users = new ArrayList<User>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "course_college",
			joinColumns = { @JoinColumn(name = "courseId")},
			inverseJoinColumns = { @JoinColumn(name = "collegeId")}
			)
	List<College> colleges = new ArrayList<College>();
}
