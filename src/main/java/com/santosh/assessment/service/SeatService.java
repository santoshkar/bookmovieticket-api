package com.santosh.assessment.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.assessment.dto.SeatDto;
import com.santosh.assessment.entity.Seat;
import com.santosh.assessment.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	public Map<String, Set<SeatDto>> findAllSeatsForScreen(String screenId) {

		List<Seat> list = seatRepository.findByScreen_screenId(UUID.fromString(screenId));

		Map<String, Set<SeatDto>> seatMapByRowName = new TreeMap<>();

		list.stream().forEach(e -> {
			String rowLabel = e.getRowName();
			int ticketNumber = e.getTicketNo();

			Set<SeatDto> seats;
			if (seatMapByRowName.containsKey(rowLabel)) {
				seats = seatMapByRowName.get(rowLabel);
			} else {
				seats = new TreeSet<>();
			}
			
			seats.add(new SeatDto(rowLabel, String.valueOf(ticketNumber), ticketNumber));
			seatMapByRowName.put(rowLabel, seats);
		});
		return seatMapByRowName;
	}
}
