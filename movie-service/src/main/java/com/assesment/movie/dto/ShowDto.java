package com.assesment.movie.dto;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class ShowDto {
	
	private String showId;
	
	private String movieTitle;
	
	private String screenId;
	
	private String showDate;
	
	private String showTime; 
	
	
	public ShowDto(String showId, String movieTitle, String screenId, Date showDate, Time showTime) {
		super();
		this.showId = showId;
		this.movieTitle = movieTitle;
		this.screenId = screenId;
		this.showDate = getFormattedDate(showDate);
		this.showTime = getFormattedTime(showTime);
	}

	public String getFormattedTime(Time time) {
		DateFormat format = new SimpleDateFormat("h:mm a");
		String str = format.format(time);
		return str;
	}

	public String getFormattedDate(Date date) {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String str = format.format(date);
		return str;
	}
}
