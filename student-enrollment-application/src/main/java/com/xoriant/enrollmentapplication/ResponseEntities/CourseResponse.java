package com.xoriant.enrollmentapplication.ResponseEntities;

import java.util.ArrayList;
import java.util.List;

import com.xoriant.enrollmentapplication.RequestEntities.UserRequest;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CourseResponse {

	private int courseId;
	private String courseName;
	private UserRequest userId;
	private List<CollegeResponse> colleges = new ArrayList<CollegeResponse>();
}
