package com.santosh.assessment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.assessment.dto.MovieShowResponseDto;
import com.santosh.assessment.dto.ScreenResponseElement;
import com.santosh.assessment.dto.ScreeningResponse;
import com.santosh.assessment.entity.MovieMaster;
import com.santosh.assessment.entity.MovieReleaseMaster;
import com.santosh.assessment.entity.ScreenMaster;
import com.santosh.assessment.entity.ShowMaster;
import com.santosh.assessment.entity.TheatreMaster;
import com.santosh.assessment.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/movie")
	public ResponseEntity<?> findAllMoviesByCityId(@RequestParam String cityId) {
		List<MovieReleaseMaster> entities = movieService.findAllReleasesByCityId(cityId);
		List<MovieMaster> movielist = entities.stream().map(e -> e.getMovie()).collect(Collectors.toList());
		return ResponseEntity.ok(movielist);
	}

	@GetMapping("/show")
	public ResponseEntity<?> findTheatreAndTimeByMovidId(@RequestParam String movieId, @RequestParam String cityId,
			@RequestParam String date) throws ParseException {
		
		MovieMaster movie = movieService.findMovie(movieId);
		Date movieDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		List<ShowMaster> showList = movieService.findTheatresAndTimesForMovie(movieId, cityId, movieDate);
		
		Map<TheatreMaster, List<ShowMaster>> map = new HashMap<>();

		showList.forEach(e -> {
			ScreenMaster screen = e.getScreen();
			TheatreMaster theatre = screen.getTheatre();
			
			List<ShowMaster> _list;
			if(map.get(theatre) != null) {
				_list = map.get(theatre);
			} else {
				_list = new ArrayList<>();
				
			}
			_list.add(e);
			map.put(theatre, _list);
		});
		
		ScreeningResponse response = new ScreeningResponse();
		
		map.forEach((theatre, _showList) -> {
			ScreenResponseElement e = new ScreenResponseElement();
			e.setTheatreId(theatre.getTheatreId().toString());
			e.setTheatreName(theatre.getTheatreName());
			e.setCityId(theatre.getCity().getCityId().toString());
			e.setCityName(theatre.getCity().getName());
			e.setCountryName(theatre.getCity().getCountry());
			e.setMovieId(movie.getMovieId().toString());
			e.setTitle(movie.getTitle());
			e.setMovieLanguage(movie.getLanguage());
			
			List<MovieShowResponseDto> _list = new ArrayList<>();
			_showList.forEach(show ->{
				MovieShowResponseDto dto = new MovieShowResponseDto(show, movieId);
				_list.add(dto);
			});
			
			e.setShowTimes(_list);
			
			response.addElement(e);
		});
		
		return ResponseEntity.ok(response);
	}
}
