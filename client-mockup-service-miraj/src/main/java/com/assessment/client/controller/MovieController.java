package com.assessment.client.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.client.entity.MovieMaster;
import com.assessment.client.entity.ShowMaster;
import com.assessment.client.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;


	@GetMapping("/show")
	public ResponseEntity<?> findShow(
			@RequestParam String movieTitle, 
			@RequestParam String date) throws ParseException {
		
		Date movieDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		
		MovieMaster movie = movieService.findByMovieTitle(movieTitle);
		
		List<ShowMaster> showList = movieService.findShowTimes(movie.getMovieId(), movieDate);
		return ResponseEntity.ok(showList);
	}
}
