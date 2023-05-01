package com.assesment.movie.clients;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.assesment.movie.dto.BookingDto;
import com.assesment.movie.dto.ShowDto;
import com.assesment.movie.dto.TicketPriceDto;

public interface IClient {
	@GetMapping("/show")
	public List<ShowDto> findShow(@RequestParam String movieTitle, @RequestParam String date);

	@GetMapping("/ticket-price")
	public ResponseEntity<TicketPriceDto> findTicketPrice(@RequestParam String screenId);

	@GetMapping("/seat")
	public ResponseEntity<?> findSeats(@RequestParam String screenId, @RequestParam String showId);

	@PostMapping("/book")
	public ResponseEntity<?> bookTicket(@RequestBody BookingDto booking);

	@GetMapping("/book")
	public ResponseEntity<?> findBooking(@RequestParam String screenId);
}
