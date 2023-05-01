package com.assesment.movie.controller;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assesment.movie.clients.IClient;
import com.assesment.movie.dto.ScreenResponseElement;
import com.assesment.movie.dto.ScreeningResponse;
import com.assesment.movie.dto.ShowDto;
import com.assesment.movie.entity.MovieMaster;
import com.assesment.movie.entity.MovieReleaseMaster;
import com.assesment.movie.factory.ClientFactory;
import com.assesment.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private ClientFactory clientBuilder;

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

	@GetMapping("/show")
	public ResponseEntity<?> findShow(@RequestParam String movieTitle, @RequestParam String date)
			throws ParseException, InterruptedException, ExecutionException {

		List<String> clientNames = clientBuilder.getClientNames();

		ScreeningResponse response = new ScreeningResponse();

		clientNames.forEach(c -> {

			IClient _iClient = clientBuilder.getClientApiByClientName(c);
			List<ShowDto> list = _iClient.findShow(movieTitle, date);

			if (list.size() > 0) {
				ScreenResponseElement res = new ScreenResponseElement();
				res.setMovieTitle(movieTitle);
				res.setMovieLanguage("English");
				res.setCityName("Hyderabad");
				res.setTheatreName(c);
				res.addShowTimes(list);
				response.addElement(res);
			}
		});

		return ResponseEntity.ok(response);
	}

}
