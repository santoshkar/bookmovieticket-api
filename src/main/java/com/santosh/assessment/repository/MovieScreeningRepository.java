package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.MovieScreening;

public interface MovieScreeningRepository extends JpaRepository<MovieScreening, UUID> {
//	List<MovieTheatre> findByMovieId(UUID movidId);
//	List<MovieTheatre> findByMovieIdAndTheatre_city_id(UUID movieId, UUID cityId);
	List<MovieScreening> findByMovieTheatre_id(UUID movieTheatreId);
}
