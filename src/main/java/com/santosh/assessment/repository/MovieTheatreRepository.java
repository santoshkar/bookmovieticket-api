package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.MovieTheatre;

public interface MovieTheatreRepository extends JpaRepository<MovieTheatre, UUID> {
	List<MovieTheatre> findByMovieId(UUID movidId);
	List<MovieTheatre> findByMovieIdAndTheatre_city_id(UUID movieId, UUID cityId);
}
