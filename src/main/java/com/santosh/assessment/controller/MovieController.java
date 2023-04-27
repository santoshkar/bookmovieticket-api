package com.santosh.assessment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.entity.Movie;
import com.santosh.assessment.entity.MovieRelease;
import com.santosh.assessment.entity.MovieScreening;
import com.santosh.assessment.entity.MovieTheatre;
import com.santosh.assessment.entity.Theatre;
import com.santosh.assessment.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping("/movie")
	public ResponseEntity<?> findAllMoviesByCityId(@RequestParam String cityId) {
		List<MovieRelease> entities = movieService.findAllCitiesByCityId(cityId);
		List<Movie> movielist = entities.stream().map(e -> e.getMovie()).collect(Collectors.toList());
		return ResponseEntity.ok(movielist);
	}
	
	@GetMapping("/theatre")
	public ResponseEntity<?> findTheatreAndTimeByMovidId(@RequestParam String movieId, @RequestParam String cityId) {
		List<MovieTheatre> entities = movieService.findTheatreAndTimeByMovieId(movieId, cityId);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Map<Theatre, List<MovieScreening>> map = new HashMap<>();
		
		entities.forEach(movieTheatre -> {
			service.execute(()->{
				UUID id = movieTheatre.getId();
				List<MovieScreening> screeningList = movieService.findScreeningByMovieTheatreId(id);
				map.put(movieTheatre.getTheatre(), screeningList);
			});
		});
		
		service.shutdown();
		try {
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
		  e.printStackTrace();
		}
		
		return ResponseEntity.ok(map);
	}
}
