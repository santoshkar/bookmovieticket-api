package com.assesment.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.movie.entity.MovieMaster;
import com.assesment.movie.entity.MovieReleaseMaster;
import com.assesment.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/movies")
	public ResponseEntity<?> findAllMoviesByCityId(@RequestParam(required = false) String cityId) {

		if (StringUtils.isBlank(cityId)) {
			List<MovieMaster> entities = movieService.findMovies();
			return ResponseEntity.ok(entities);
		} else {
			List<MovieReleaseMaster> entities2 = movieService.findAllReleasesByCityId(cityId);
			List<MovieMaster> movielist = entities2.stream().map(e -> e.getMovie()).collect(Collectors.toList());
			return ResponseEntity.ok(movielist);
		}
	}

}
