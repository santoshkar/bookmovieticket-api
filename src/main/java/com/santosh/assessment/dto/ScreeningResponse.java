package com.santosh.assessment.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ScreeningResponse {
	List<ScreenResponseElement> screenList = new ArrayList<>();
	
	public void addElement(ScreenResponseElement e) {
		this.screenList.add(e);
	}
}

