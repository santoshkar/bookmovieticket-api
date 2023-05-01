package com.assesment.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.movie.clients.IClient;
import com.assesment.movie.factory.ClientFactory;

@RestController
public class SeatController {
	
	@Autowired
	private ClientFactory clientFactory;;

	@GetMapping("/seat")
	public ResponseEntity<?> findSeats(
			@RequestParam String clientName,
			@RequestParam String screenId,  
			@RequestParam String showId) {
		
		IClient clientApi = clientFactory.getClientApiByClientName(clientName);
		
		return clientApi.findSeats(screenId, showId);
	}
}
