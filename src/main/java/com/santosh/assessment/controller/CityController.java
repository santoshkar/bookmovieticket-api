package com.santosh.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.entity.City;
import com.santosh.assessment.service.CityService;

@RestController
public class CityController {
	@Autowired
	private CityService cityService;

	@GetMapping("/city")
	public ResponseEntity<?> loginCustomer() {
		List<City> entities = cityService.findAllCities();
		return ResponseEntity.ok(entities);
	}
}
