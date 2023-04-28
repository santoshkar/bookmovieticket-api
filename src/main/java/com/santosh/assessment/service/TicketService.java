package com.santosh.assessment.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.assessment.entity.TicketPrice;
import com.santosh.assessment.repository.TicketPriceRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketPriceRepository ticketPriceRepo;
	
	public TicketPrice getTicketPriceByScreeningId(String screeningId){
		return ticketPriceRepo.findByMovieScreening_id(UUID.fromString(screeningId));	
	}
}
