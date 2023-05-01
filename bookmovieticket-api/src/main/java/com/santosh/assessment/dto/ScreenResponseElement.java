package com.santosh.assessment.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ScreenResponseElement{
	
	private String theatreId;
	private String theatreName;
	private String cityId;
	private String cityName;
	private String countryName;
	private String movieId;
	private String title;
	private String movieLanguage;
	
	private List<MovieShowResponseDto> showTimes = new ArrayList<>();
	
	public void addElement(MovieShowResponseDto dto) {
		this.showTimes.add(dto);
	}
}
