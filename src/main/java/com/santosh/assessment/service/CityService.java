package com.santosh.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.assessment.entity.City;
import com.santosh.assessment.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepo;

	public List<City> findAllCities() {
		return cityRepo.findAll();
	}

}
