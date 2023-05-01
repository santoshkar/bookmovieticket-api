package com.assessment.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.client.service.BookingDto;
import com.assessment.client.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/book")
	public ResponseEntity<?> bookTicket(@RequestBody BookingDto booking) {
		bookingService.bookTicket(booking);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/book")
	public ResponseEntity<?> findBooking(@RequestParam String screenId) {
		return ResponseEntity.ok().build();
	}
}
