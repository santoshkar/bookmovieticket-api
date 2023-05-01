package com.assesment.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.movie.clients.IClient;
import com.assesment.movie.factory.ClientFactory;

@RestController
public class TicketController {

	@Autowired
	private ClientFactory clientBuilder;

	@GetMapping("/ticket-price")
	public ResponseEntity<?> findTicketPrice(@RequestParam String screenId, @RequestParam String clientName) {

		IClient _iClient = clientBuilder.getClientApiByClientName(clientName);
		return _iClient.findTicketPrice(screenId);
	}

}
