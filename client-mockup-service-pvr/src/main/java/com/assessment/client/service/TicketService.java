package com.assessment.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.client.entity.TicketPrice;
import com.assessment.client.repository.TicketPriceRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketPriceRepository ticketPriceRepo;
	
	public TicketPrice getTicketPriceByMovieTheatreId(String screenId){
		return ticketPriceRepo.findByScreenId(screenId);	
	}
}
