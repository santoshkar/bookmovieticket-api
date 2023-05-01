package com.santosh.assessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.MovieMaster;

public interface MovieRepository extends JpaRepository<MovieMaster, UUID> {
//	List<MovieMaster> findByLanguageIgnoreCase(String language);
//	MovieMaster findByTitleContainingIgnoreCase(String partialText);
//	List<MovieMaster> findByLanguageAndTitleContainingIgnoreCase(String language, String partialText);
}
