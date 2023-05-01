package com.assessment.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.client.entity.BookingMaster;
import com.assessment.client.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	public void bookTicket(BookingDto booking) {

		List<BookingMaster> bookings = new ArrayList<>();

		booking.getSelectedSeats().forEach(seat -> {
			BookingMasterBuilder bookingMaster = BookingMaster.builder();
			BookingMaster _b = bookingMaster.customer(booking.getCustomerId()).show(booking.getShowId()).seat(seat)
					.bookingStatus(booking.getBookingStatus()).paymentMode(booking.getPaymentMode())
					.amountPaid(booking.getAmount()).build();
			bookings.add(_b);
		});

		bookingRepo.saveAll(bookings);
	}

//	public TicketPrice getTicketPriceByMovieTheatreId(String screenId){
//		return ticketPriceRepo.findByScreen_screenId(UUID.fromString(screenId));	
//	}
}
