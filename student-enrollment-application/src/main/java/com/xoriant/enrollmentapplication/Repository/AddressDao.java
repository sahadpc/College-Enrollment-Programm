package com.xoriant.enrollmentapplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xoriant.enrollmentapplication.entities.Address;
@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{
	

	@Query("select a From address a WHERE a.userId.userId=:userId")
	public List<Address> findAddressesByUserId(@Param("userId") int userId);
	 
	
}
