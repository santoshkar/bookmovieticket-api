package com.assessment.client.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatDto implements Comparable<SeatDto> {

	private String seatId;
	private String rowLabel;
	private String ticketNumber;
	private int index;
	private String status = "AVAILABLE";	//TODO: to be number

	public String getTicketNumber() {
		return rowLabel + ticketNumber;
	}

	@Override
	public int compareTo(SeatDto o) {
		return this.getTicketNumber().compareTo(o.getTicketNumber());
	}
	
	
}
