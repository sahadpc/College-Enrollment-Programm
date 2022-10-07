package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xoriant.enrollmentapplication.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	public User findByEmailId(String email);
	//public Boolean existsByUsername(String username);
	public Boolean existsByEmailId(String email);
	
	
	
}
