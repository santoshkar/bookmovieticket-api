package com.assessment.booking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.booking.BookingMaster.BookingMasterBuilder;


@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	public void bookTicket(BookingDto booking) {

		List<BookingMaster> bookings = new ArrayList<>();

		booking.getSelectedSeats().forEach(seat -> {
			BookingMasterBuilder bookingMaster = BookingMaster.builder();
			BookingMaster _b = bookingMaster.customerId(booking.getCustomerId()).showId(booking.getShowId()).seatId(seat)
					.bookingStatus(booking.getBookingStatus()).paymentMode(booking.getPaymentMode())
					.amountPaid(booking.getAmount()).build();
			bookings.add(_b);
		});

		bookingRepo.saveAll(bookings);
	}
}
