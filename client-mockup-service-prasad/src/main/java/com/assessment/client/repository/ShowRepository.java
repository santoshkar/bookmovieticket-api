package com.assessment.client.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.client.entity.ShowMaster;

public interface ShowRepository extends JpaRepository<ShowMaster, UUID> {
	List<ShowMaster> findByMovieIdAndShowDate(String movieId, Date date);
}
