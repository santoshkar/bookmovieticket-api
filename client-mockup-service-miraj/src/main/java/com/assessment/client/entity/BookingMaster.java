package com.assessment.client.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import com.assessment.client.service.BookingMasterBuilder;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class BookingMaster {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID bookingId;
	
//	@ManyToOne
//	@JoinColumn(name = "customer_id")
//	@JsonManagedReference
//	private CustomerMaster customer;
	
	private String customerId;
	
	@ManyToOne
	@JoinColumn(name = "show_id")
	@JsonManagedReference
	private ShowMaster show;
	
	@OneToOne
	@JoinColumn(name = "seat_id")
	@JsonManagedReference
	private Seat seat;
	
	private String bookingStatus;
	
	@CreationTimestamp
	private Date bookingDateTime;
	
	@UpdateTimestamp
	private Date lastUpdatedDateTime;
	
	private String paymentMode;
	
	private float amountPaid;
	
	private float amountRefunded;

	public static BookingMasterBuilder builder() {
		return new BookingMasterBuilder();
	}
}
