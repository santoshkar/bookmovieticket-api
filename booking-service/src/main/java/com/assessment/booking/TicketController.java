package com.assessment.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.entity.TicketPrice;
import com.santosh.assessment.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/ticket-price")
	public ResponseEntity<?> findTicketPrice(@RequestParam String screenId){
		TicketPrice price = ticketService.getTicketPriceByMovieTheatreId(screenId);
		return ResponseEntity.ok(price);
	}
}
