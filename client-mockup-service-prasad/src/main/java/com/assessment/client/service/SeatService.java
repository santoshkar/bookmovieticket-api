package com.assessment.client.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.client.entity.BookingMaster;
import com.assessment.client.entity.Seat;
import com.assessment.client.repository.BookingRepository;
import com.assessment.client.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private BookingRepository bookingRepo;

	public Map<String, Set<SeatDto>> findAllSeatsForScreen(String screenId, String showId) {

		List<String> seatIds = findAllSeatIdsFromBookings(showId);
		List<Seat> list = seatRepository.findByScreen_screenId(UUID.fromString(screenId));

		Map<String, Set<SeatDto>> seatMapByRowName = new TreeMap<>();

		list.stream().forEach(e -> {
			String seatId = e.getSeatId().toString();
			String rowLabel = e.getRowName();
			int ticketNumber = e.getTicketNo();

			Set<SeatDto> seats;
			if (seatMapByRowName.containsKey(rowLabel)) {
				seats = seatMapByRowName.get(rowLabel);
			} else {
				seats = new TreeSet<>();
			}
			
			String status = seatIds.contains(seatId)?"NOTAVAILABLE": "AVAILABLE";
			seats.add(new SeatDto(seatId, rowLabel, String.valueOf(ticketNumber), ticketNumber, status));
			seatMapByRowName.put(rowLabel, seats);
		});
		return seatMapByRowName;
	}
	
	List<String> findAllSeatIdsFromBookings(String showId){
		String[] status = {"BOOKED", "HOLD"};
		List<BookingMaster> list = bookingRepo.findByShow_showIdAndBookingStatusIn(UUID.fromString(showId), status);
		return list.stream().map(e -> e.getSeat().getSeatId().toString()).collect(Collectors.toList());
	}
}
