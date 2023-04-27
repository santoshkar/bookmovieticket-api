package com.santosh.assessment.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.assessment.entity.MovieRelease;
import com.santosh.assessment.entity.MovieScreening;
import com.santosh.assessment.entity.MovieTheatre;
import com.santosh.assessment.repository.MovieReleaseRepository;
import com.santosh.assessment.repository.MovieScreeningRepository;
import com.santosh.assessment.repository.MovieTheatreRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieReleaseRepository movieReleaseRepo;
	
	@Autowired
	private MovieScreeningRepository movieScreeningRepo;
	
	@Autowired
	private MovieTheatreRepository movieTheatreRepo;

	public List<MovieRelease> findAllCitiesByCityId(String cityId) {
		return movieReleaseRepo.findByCity_id(UUID.fromString(cityId));
	}
	
	public  List<MovieTheatre> findScreenTimings(String movieId, String cityId) {
		return movieTheatreRepo.findByMovieIdAndTheatre_city_id(UUID.fromString(movieId), UUID.fromString(cityId));
	}

	public  List<MovieTheatre> findTheatreAndTimeByMovieId(String movieId, String cityId) {
		return movieTheatreRepo.findByMovieIdAndTheatre_city_id(UUID.fromString(movieId), UUID.fromString(cityId));
	}

	public List<MovieScreening> findScreeningByMovieTheatreId(String movieTheatreId) {
		return movieScreeningRepo.findByMovieTheatre_id(UUID.fromString(movieTheatreId));
	}
	
	public List<MovieScreening> findScreeningByMovieTheatreId(UUID movieTheatreId) {
		return movieScreeningRepo.findByMovieTheatre_id(movieTheatreId);
	}

}
