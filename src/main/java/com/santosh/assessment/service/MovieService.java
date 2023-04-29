package com.santosh.assessment.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.assessment.entity.CityMaster;
import com.santosh.assessment.entity.MovieMaster;
import com.santosh.assessment.entity.MovieReleaseMaster;
import com.santosh.assessment.entity.ShowMaster;
import com.santosh.assessment.repository.MovieReleaseRepository;
import com.santosh.assessment.repository.MovieRepository;
import com.santosh.assessment.repository.ShowRepository;

@Service
public class MovieService {

	@Autowired
	private MovieReleaseRepository movieReleaseRepo;

	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private MovieRepository movieRepo;


	public MovieMaster findMovie(String movieId) {
		return movieRepo.findById(UUID.fromString(movieId)).get();
	}

	public List<MovieReleaseMaster> findAllReleasesByCityId(String cityId) {
		return movieReleaseRepo.findByCity(new CityMaster(cityId));
	}

	public MovieReleaseMaster findReleaseByMovieAndCity(String movieId, String cityId) {
		return movieReleaseRepo.findByMovie_movieIdAndCity_cityId(UUID.fromString(movieId), UUID.fromString(cityId));
	}

	public List<ShowMaster> findTheatresAndTimesForMovie(String movieId, String cityId, Date movieDate) {
		MovieReleaseMaster release = findReleaseByMovieAndCity(movieId, cityId);
		List<ShowMaster> list = showRepository.findByReleaseAndShowDate(release, movieDate);
		return list;
	}

//	public  List<MovieTheatreScreen> findScreenTimings(String movieId, String cityId) {
//		return movieAndTheatreRepo.findByMovieIdAndTheatreScreen_Theatre_City_id(UUID.fromString(movieId), UUID.fromString(cityId));
//	}
//
//	public List<MovieTheatreScreen> findMovieAndTheatreByMovieTheatreIdAndDate(String movieTheatreId, Date movieDate) {
//		return movieAndTheatreRepo.findByIdAndShowDate(UUID.fromString(movieTheatreId), movieDate);
//	}
}
