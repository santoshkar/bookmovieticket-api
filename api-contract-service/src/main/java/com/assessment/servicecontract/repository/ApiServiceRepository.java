package com.assessment.servicecontract.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.servicecontract.entity.ApiServiceMaster;

public interface ApiServiceRepository extends JpaRepository<ApiServiceMaster, UUID> {
	ApiServiceMaster findByTheatreIdAndApiName(String clientId, String apiName);
}
