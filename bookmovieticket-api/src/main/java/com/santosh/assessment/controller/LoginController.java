package com.santosh.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.dto.LoginDto;
import com.santosh.assessment.entity.CustomerMaster;
import com.santosh.assessment.exception.CustomerNotFoundException;
import com.santosh.assessment.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/customer-login")
	public ResponseEntity<?> loginCustomer(@RequestBody LoginDto loginDto){
		CustomerMaster entity = loginService.findCustomer(loginDto);
		if(entity == null)
			throw new CustomerNotFoundException("Invalid username or password");
		return ResponseEntity.ok(entity);
	}
}

