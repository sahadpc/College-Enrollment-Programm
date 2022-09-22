package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.enrollmentapplication.entities.StudentMarks;
@Repository
public interface StudentMarkDao extends JpaRepository<StudentMarks, Integer>{
}
