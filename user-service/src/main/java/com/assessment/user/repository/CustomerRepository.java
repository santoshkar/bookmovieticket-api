package com.assessment.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.user.entity.CustomerMaster;

public interface CustomerRepository extends JpaRepository<CustomerMaster, UUID> {
	CustomerMaster findByUserNameAndPassword(String username, String password);
//	List<TheatreScreen> findByCity_cityIgnoreCase(String city);
}
