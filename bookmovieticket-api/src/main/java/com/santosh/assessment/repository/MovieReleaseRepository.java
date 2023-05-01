package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.CityMaster;
import com.santosh.assessment.entity.MovieReleaseMaster;

public interface MovieReleaseRepository extends JpaRepository<MovieReleaseMaster, UUID> {
	List<MovieReleaseMaster> findByCity(CityMaster city);
	
	MovieReleaseMaster findByMovie_movieIdAndCity_cityId(UUID movieId, UUID cityId);
}
