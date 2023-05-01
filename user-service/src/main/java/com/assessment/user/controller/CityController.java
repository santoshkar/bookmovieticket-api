package com.assessment.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.user.entity.CityMaster;
import com.assessment.user.service.CityService;

@RestController
public class CityController {
	@Autowired
	private CityService cityService;

	@GetMapping("/cities")
	@Cacheable("cities")
	public ResponseEntity<?> findAll() {
		List<CityMaster> entities = cityService.findAllCities();
		return ResponseEntity.ok(entities);
	}
	
}
