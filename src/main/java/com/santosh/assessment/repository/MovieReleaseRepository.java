package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.MovieRelease;

public interface MovieReleaseRepository extends JpaRepository<MovieRelease, UUID> {
//	TheatreScreen findByNameAndScreenNo(String name, int screenNo);
	List<MovieRelease> findByCity_id(UUID city_id);
//	List<TheatreScreen> findByCity_cityIgnoreCase(String city);
//	List<TheatreScreen> findByNameContainingIgnoreCase(String partialText);
}
