package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.Customer;
import com.santosh.assessment.entity.TheatreScreen;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
	Customer findByUserNameAndPassword(String username, String password);
	List<TheatreScreen> findByCity_cityIgnoreCase(String city);
}
