package com.assessment.client.service;

import java.util.UUID;

import com.assessment.client.entity.BookingMaster;
import com.assessment.client.entity.Seat;
import com.assessment.client.entity.ShowMaster;
//import com.santosh.assessment.entity.CustomerMaster;

public class BookingMasterBuilder {

	private BookingMaster bm;

	public BookingMasterBuilder() {
		bm = new BookingMaster();
	}

	public BookingMasterBuilder(BookingMaster bookingMaster) {
		bm = bookingMaster;
	}

	public BookingMasterBuilder customer(String customerId) {
//		UUID id = UUID.fromString(customerId);
//		CustomerMaster _o = new CustomerMaster();
//		_o.setCustomerId(id);
		bm.setCustomerId(customerId);
		return this;
	}

	public BookingMasterBuilder show(String showId) {
		UUID id = UUID.fromString(showId);
		ShowMaster _o = new ShowMaster();
		_o.setShowId(id);
		bm.setShow(_o);
		return this;
	}

	public BookingMasterBuilder seat(String seatId) {
		UUID id = UUID.fromString(seatId);
		Seat _o = new Seat();
		_o.setSeatId(id);
		bm.setSeat(_o);
		return this;
	}

	public BookingMasterBuilder bookingStatus(String bookingStatus) {
		bm.setBookingStatus(bookingStatus);
		return this;
	}

	public BookingMasterBuilder paymentMode(String paymentMode) {
		bm.setPaymentMode(paymentMode);
		return this;
	}

	public BookingMasterBuilder amountPaid(float amountPaid) {
		bm.setAmountPaid(amountPaid);
		return this;
	}

	public BookingMasterBuilder amountRefunded(float amountRefunded) {
		bm.setAmountRefunded(amountRefunded);
		return this;
	}

	public BookingMaster build() {
		return bm;
	}
}
