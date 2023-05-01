package com.assessment.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.user.dto.LoginDto;
import com.assessment.user.entity.CustomerMaster;
import com.assessment.user.exception.CustomerNotFoundException;
import com.assessment.user.service.LoginService;

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

