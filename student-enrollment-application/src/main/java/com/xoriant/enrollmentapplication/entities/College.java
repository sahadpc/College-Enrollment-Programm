package com.xoriant.enrollmentapplication.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "college")
public class College {

	@Id
	@GeneratedValue
	private int collegeId;
	private String collegeName;
	private int totalSeats;
	private int availableSeats;
	
	@ManyToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<User> users;
	
	@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "college_course",
		joinColumns = {
				@JoinColumn(name = "collegeId", referencedColumnName = "collegeId")
		},
		inverseJoinColumns = {
				@JoinColumn(name = "courseId", referencedColumnName = "courseId")
		})
	private List<Course> courses;
}

