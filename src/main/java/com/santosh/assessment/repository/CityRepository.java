package com.santosh.assessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.City;

public interface CityRepository extends JpaRepository<City, UUID> {
	
}
