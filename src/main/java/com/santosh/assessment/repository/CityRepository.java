package com.santosh.assessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, UUID> {
	
}
