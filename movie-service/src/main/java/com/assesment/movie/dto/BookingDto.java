package com.assesment.movie.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookingDto
{
	private String customerId;
	private String showId;
	private List<String> selectedSeats;
	private String bookingStatus;
	private String paymentMode;
	private float amount;
}