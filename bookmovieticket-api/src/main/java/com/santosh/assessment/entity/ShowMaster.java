package com.santosh.assessment.entity;

import java.sql.Time;
import java.util.Date;
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
public class ShowMaster {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid2")
	@Column(columnDefinition = "VARCHAR(255)")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID showId;
	
	@ManyToOne
	@JoinColumn(name = "release_id")
	@JsonManagedReference
	private MovieReleaseMaster release;
	
	@ManyToOne
	@JoinColumn(name = "screen_id")
	@JsonManagedReference
	private ScreenMaster screen;
	
	private Date showDate;
	
	private Time showTime; 
}
