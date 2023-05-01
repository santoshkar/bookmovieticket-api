package com.assessment.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.assessment.user.dto.LoginDto;
import com.assessment.user.entity.CustomerMaster;
import com.assessment.user.repository.CustomerRepository;

@Service
public class LoginService {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Cacheable("login")
	public CustomerMaster findCustomer(LoginDto loginDto) {
		return customerRepo.findByUserNameAndPassword(loginDto.getUsername(), loginDto.getPassword());
	}

}
