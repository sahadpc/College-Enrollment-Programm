package com.xoriant.enrollmentapplication.ResponseEntities;

import com.xoriant.enrollmentapplication.entities.Course;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CollegeResponse {
	
	private int collegeId;
	private String collegeName;
	private Course courseId;
}
