package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.enrollmentapplication.entities.College;

public interface CollegeDao extends JpaRepository<College, Integer>{
	//public College findByCourseId(int courseId);
}
