package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.enrollmentapplication.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer>{

}
