package com.assessment.servicecontract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.servicecontract.entity.ApiServiceMaster;
import com.assessment.servicecontract.service.ApiContractService;

@RestController
public class ApiController {

	@Autowired
	private ApiContractService apiService;

	@GetMapping("/api-service")
	public ResponseEntity<?> findApiService(@RequestParam String theatreId, @RequestParam String apiName) {
		ApiServiceMaster _data = apiService.findByTheatreIdAndApiName(theatreId, apiName);
		return ResponseEntity.ok(_data);
	}
	
	@PostMapping("/api-service")
	public ResponseEntity<?> createApiService(@RequestBody ApiServiceMaster apiObj) {
		ApiServiceMaster _data = apiService.saveOrUpdate(apiObj);
		return ResponseEntity.ok(_data);
	}
	
	@PutMapping("/api-service")
	public ResponseEntity<?> updateApiService(@RequestBody ApiServiceMaster apiObj) {
		ApiServiceMaster _data = apiService.saveOrUpdate(apiObj);
		return ResponseEntity.ok(_data);
	}

}
