package com.santosh.assessment.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.santosh.assessment.controller.LoginController;
import com.santosh.assessment.exception.CustomerNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(assignableTypes = LoginController.class)
public class UserNotFoundExceptionHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(CustomerNotFoundException ex, WebRequest request) {

		log.debug("In UserNotFoundExceptionHandler");

		ErrorDetail error = new ErrorDetail(new Date(), ex.toString(), ex.toString());

		return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
