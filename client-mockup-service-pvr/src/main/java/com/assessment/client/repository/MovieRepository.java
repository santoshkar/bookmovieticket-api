package com.assessment.client.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.client.entity.MovieMaster;

public interface MovieRepository extends JpaRepository<MovieMaster, UUID> {
	
	MovieMaster findByTitle(String title);
	
}
