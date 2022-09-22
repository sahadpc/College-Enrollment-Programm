package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.enrollmentapplication.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
