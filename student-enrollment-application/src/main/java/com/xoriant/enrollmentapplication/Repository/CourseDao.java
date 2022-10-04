package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.enrollmentapplication.entities.Course;

public interface CourseDao extends JpaRepository<Course, Integer>{

	//public Course findByUserId(int userId);
}
