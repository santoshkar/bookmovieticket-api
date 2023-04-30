package com.santosh.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatDto implements Comparable<SeatDto> {

	private String rowLabel;
	private String ticketNumber;
	private int index;

	public String getTicketNumber() {
		return rowLabel + ticketNumber;
	}

	@Override
	public int compareTo(SeatDto o) {
		return this.getTicketNumber().compareTo(o.getTicketNumber());
	}
	
	
}
