package com.xoriant.enrollmentapplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.enrollmentapplication.entities.Address;
@Repository
public interface AddressDao extends JpaRepository<Address, Integer>{

}
