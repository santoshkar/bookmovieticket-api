package com.assesment.movie.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.movie.entity.CityMaster;
import com.assesment.movie.entity.MovieMaster;
import com.assesment.movie.entity.MovieReleaseMaster;
import com.assesment.movie.repository.MovieReleaseRepository;
import com.assesment.movie.repository.MovieRepository;
//import com.assesment.movie.repository.ShowRepository;
//import com.assessment.client.ShowMaster;



@Service
public class MovieService {

	@Autowired
	private MovieReleaseRepository movieReleaseRepo;

//	@Autowired
//	private ShowRepository showRepository;
	
	@Autowired
	private MovieRepository movieRepo;


	public List<MovieMaster> findMovies() {
		return movieRepo.findAll();
	}

	public List<MovieReleaseMaster> findAllReleasesByCityId(String cityId) {
		return movieReleaseRepo.findByCity(new CityMaster(cityId));
	}

//	public MovieReleaseMaster findReleaseByMovieAndCity(String movieId, String cityId) {
//		return movieReleaseRepo.findByMovie_movieIdAndCity_cityId(UUID.fromString(movieId), UUID.fromString(cityId));
//	}

//	public List<ShowMaster> findTheatresAndTimesForMovie(String movieId, String cityId, Date movieDate) {
//		MovieReleaseMaster release = findReleaseByMovieAndCity(movieId, cityId);
//		List<ShowMaster> list = showRepository.findByReleaseAndShowDate(release, movieDate);
//		return list;
//	}

//	public  List<MovieTheatreScreen> findScreenTimings(String movieId, String cityId) {
//		return movieAndTheatreRepo.findByMovieIdAndTheatreScreen_Theatre_City_id(UUID.fromString(movieId), UUID.fromString(cityId));
//	}
//
//	public List<MovieTheatreScreen> findMovieAndTheatreByMovieTheatreIdAndDate(String movieTheatreId, Date movieDate) {
//		return movieAndTheatreRepo.findByIdAndShowDate(UUID.fromString(movieTheatreId), movieDate);
//	}
}
