package com.santosh.assessment.dto;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.santosh.assessment.entity.ShowMaster;

import lombok.Data;

@Data
public class MovieShowResponseDto {

	private String showId;
	private String movieId;
	private String screenId;
	private String showDate;
	private String showTime;

	public MovieShowResponseDto(ShowMaster showMaster, String movieId) {
		this(showMaster.getShowId().toString(), movieId, showMaster.getScreen().getScreenId().toString(),
				showMaster.getShowDate(), showMaster.getShowTime());
	}

	public MovieShowResponseDto(String showId, String movieId, String screenId, Date showDate, Time showTime) {
		super();
		this.showId = showId;
		this.movieId = movieId;
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
