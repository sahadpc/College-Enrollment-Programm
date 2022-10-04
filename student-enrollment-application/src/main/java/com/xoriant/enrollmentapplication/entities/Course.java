package com.xoriant.enrollmentapplication.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "course")
public class Course {

	@Id
	private int courseId;
	private String courseName;
	
	@ManyToMany (mappedBy = "college", fetch = FetchType.LAZY)
	private List<College> colleges;
}

