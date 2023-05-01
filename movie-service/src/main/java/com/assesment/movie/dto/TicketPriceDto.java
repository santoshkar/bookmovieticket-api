package com.assesment.movie.dto;

import lombok.Data;

@Data
public class TicketPriceDto {
	private String ticketPriceId;
	private String screenId;
	private float price;
}
