package com.assesment.movie.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assesment.movie.entity.CityMaster;
import com.assesment.movie.entity.MovieReleaseMaster;

public interface MovieReleaseRepository extends JpaRepository<MovieReleaseMaster, UUID> {
	List<MovieReleaseMaster> findByCity(CityMaster city);
	
	MovieReleaseMaster findByMovie_movieIdAndCity_cityId(UUID movieId, UUID cityId);
}
