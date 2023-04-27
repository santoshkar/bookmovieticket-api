package com.santosh.assessment.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ScreenResponseElement{
	private String theatreName;
	private String city;
	private List<ScreenIdAndtimeDto> screens = new ArrayList<>();
	
	public void addElement(ScreenIdAndtimeDto dto) {
		this.screens.add(dto);
	}
}