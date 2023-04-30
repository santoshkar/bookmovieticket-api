package com.santosh.assessment.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.dto.SeatDto;
import com.santosh.assessment.service.SeatService;

import lombok.Data;

@RestController
public class SeatController {

	@Autowired
	private SeatService seatService;

	@GetMapping("/seat")
	public ResponseEntity<?> findSeats(@RequestParam String screenId) {
		Map<String, Set<SeatDto>> data = seatService.findAllSeatsForScreen(screenId);
		
		SeatResponse response = new SeatResponse();
		
		data.forEach((rowLabel, setSet) -> {
			SeatRow seatRow = new SeatRow();
			seatRow.setLabel(rowLabel);
			
			setSet.forEach(seat -> {
				SeatColumn seatColumn = new SeatColumn();
				seatColumn.setLabel(seat.getTicketNumber());
				seatColumn.setIndex(seat.getIndex());
				seatRow.addElement(seatColumn);
			});
			response.addElement(seatRow);
		});
		
		return ResponseEntity.ok(response);
	}

	@Data
	public class SeatResponse {
		private List<SeatRow> rows = new ArrayList<>();
		public void addElement(SeatRow row) {
			this.rows.add(row);
		}
		public void addElements(Set<SeatRow> rows) {
			this.rows.addAll(rows);
		}
		public void addElements(List<SeatRow> rows) {
			this.rows.addAll(rows);
		}
	}

	@Data
	public class SeatRow {
		
		private String label;
		
		private List<SeatColumn> columns = new ArrayList<>();
		public void addElement(SeatColumn column) {
			this.columns.add(column);
		}
		public void addElements(Set<SeatColumn> columns) {
			this.columns.addAll(columns);
		}
		public void addElements(List<SeatColumn> columns) {
			this.columns.addAll(columns);
		}
	}

	@Data
	public class SeatColumn {
		private String label;
		private int index;
		private int bookingStatus = 0;
	}

}
