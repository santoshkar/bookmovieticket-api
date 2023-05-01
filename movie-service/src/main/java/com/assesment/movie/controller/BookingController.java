package com.assesment.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.movie.clients.IClient;
import com.assesment.movie.dto.BookingDto;
import com.assesment.movie.factory.ClientFactory;

@RestController
public class BookingController {

	@Autowired
	private ClientFactory clientFactory;

	@PostMapping("/book")
	public ResponseEntity<?> bookTicket(@RequestBody BookingDto booking, @RequestParam String clientName) {
		IClient clientApi = clientFactory.getClientApiByClientName(clientName);
		clientApi.bookTicket(booking);
		return null;
	}

	@GetMapping("/book")
	public ResponseEntity<?> findBooking(@RequestParam String screenId, @RequestParam String clientName) {
		IClient clientApi = clientFactory.getClientApiByClientName(clientName);
		clientApi.findBooking(screenId);
		return null;
	}
}
