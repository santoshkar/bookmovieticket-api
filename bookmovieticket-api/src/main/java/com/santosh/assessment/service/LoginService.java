package com.santosh.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.assessment.dto.LoginDto;
import com.santosh.assessment.entity.CustomerMaster;
import com.santosh.assessment.repository.CustomerRepository;

@Service
public class LoginService {
	
	@Autowired
	private CustomerRepository customerRepo;

	public CustomerMaster findCustomer(LoginDto loginDto) {
		return customerRepo.findByUserNameAndPassword(loginDto.getUsername(), loginDto.getPassword());
	}

}
