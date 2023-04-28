package com.santosh.assessment.entity;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.santosh.assessment.dto.ScreenIdAndtimeDto;

import lombok.Data;

@Data
@Entity
public class MovieScreening  {
    @Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", columnDefinition = "VARCHAR(255)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @JsonProperty("movieScreeningId")
    private UUID id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "movie_theatre_id", referencedColumnName = "id")
	@JsonBackReference
	private MovieTheatre movieTheatre;
	
	private Time showBeginsOn;

	private Time showEndsOn;
	
	private int screenNo;
	
	private boolean isPlayingInTheatre;
	
	public ScreenIdAndtimeDto getScreenIdAndTime() {
		DateFormat format = new SimpleDateFormat( "h:mm a" );
		String str = format.format( getShowBeginsOn() );
		return new ScreenIdAndtimeDto(getId().toString(), str);
	}
 
}
