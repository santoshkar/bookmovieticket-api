package com.assessment.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.user.entity.CityMaster;
import com.assessment.user.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepo;

	public List<CityMaster> findAllCities() {
		return cityRepo.findAll();
	}

}
