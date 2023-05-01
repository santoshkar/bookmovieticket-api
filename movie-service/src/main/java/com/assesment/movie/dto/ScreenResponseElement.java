package com.assesment.movie.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ScreenResponseElement {

	private String theatreName;
	private String movieTitle;
	private String movieLanguage;
	private String cityName;

	private List<ShowDto> showTimes = new ArrayList<>();

	public void addElement(ShowDto dto) {
		this.showTimes.add(dto);
	}

	public void addShowTimes(List<ShowDto> dtoList) {
		this.showTimes.addAll(dtoList);
	}
}
