package com.assesment.movie.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ScreeningResponse {
	private List<ScreenResponseElement> shows = new ArrayList<>();

	public void addElement(ScreenResponseElement e) {
		this.shows.add(e);
	}
}
