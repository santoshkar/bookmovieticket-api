package com.assessment.booking;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class BookingMaster {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID bookingId;
	
	private String customerId;
	
	private String showId;
	
	private String seatId;
	
	private String bookingStatus;
	
	@CreationTimestamp
	private Date bookingDateTime;
	
	@UpdateTimestamp
	private Date lastUpdatedDateTime;
	
	private String paymentMode;
	
	private float amountPaid;
	
	private float amountRefunded;

//	public static BookingMasterBuilder builder() {
//		return new BookingMasterBuilder();
//	}
}
