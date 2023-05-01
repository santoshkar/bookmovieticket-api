package com.assessment.servicecontract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.assessment.servicecontract.entity.ApiServiceMaster;
import com.assessment.servicecontract.repository.ApiServiceRepository;

@Service
public class ApiContractService {
	
	@Autowired
	private	ApiServiceRepository apiRepo;

	@Cacheable("api-service")
	public ApiServiceMaster findByTheatreIdAndApiName(String clientId, String apiName) {
		return apiRepo.findByTheatreIdAndApiName(clientId, apiName);
	}
	
	public ApiServiceMaster saveOrUpdate(ApiServiceMaster apiService) {
		return apiRepo.save(apiService);
	}
	
}
