package com.santosh.assessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.CustomerMaster;

public interface CustomerRepository extends JpaRepository<CustomerMaster, UUID> {
	CustomerMaster findByUserNameAndPassword(String username, String password);
//	List<TheatreScreen> findByCity_cityIgnoreCase(String city);
}
