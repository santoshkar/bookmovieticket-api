package com.assessment.client.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.client.entity.MovieMaster;
import com.assessment.client.entity.ShowMaster;
import com.assessment.client.repository.MovieRepository;
import com.assessment.client.repository.ShowRepository;

@Service
public class MovieService {

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private MovieRepository movieRepo;


	public MovieMaster findByMovieTitle(String movieTitle) {
		return movieRepo.findByTitle(movieTitle);
	}
	
	public List<ShowMaster> findShowTimes(UUID movieId, Date date){
		return showRepository.findByMovieIdAndShowDate(movieId.toString(), date);
	}

}
