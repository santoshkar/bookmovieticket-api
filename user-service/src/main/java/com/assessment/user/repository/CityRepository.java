package com.assessment.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.user.entity.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, UUID> {
	
}
