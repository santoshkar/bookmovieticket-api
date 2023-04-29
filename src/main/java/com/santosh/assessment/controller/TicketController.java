package com.santosh.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/ticket-price")
	public ResponseEntity<?> findTicketPrice(@RequestParam String movieTheatreId){
//		TicketPriceMaster p = ticketService.getTicketPriceByMovieTheatreId(movieTheatreId);
		return ResponseEntity.ok().build();
	}
	
}
