package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
	List<Movie> findByLanguageIgnoreCase(String language);
	Movie findByTitleContainingIgnoreCase(String partialText);
	List<Movie> findByLanguageAndTitleContainingIgnoreCase(String language, String partialText);
}
