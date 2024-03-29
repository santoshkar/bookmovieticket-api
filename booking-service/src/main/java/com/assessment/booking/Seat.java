package com.assessment.booking;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class Seat {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID seatId;

	@ManyToOne
	@JoinColumn(name = "screen_id")
	@JsonManagedReference
	private ScreenMaster screen;

	private String rowName;

	private int ticketNo;
}
