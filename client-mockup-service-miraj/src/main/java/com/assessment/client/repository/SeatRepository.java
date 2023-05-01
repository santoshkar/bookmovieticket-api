package com.assessment.client.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.client.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
	List<Seat> findByScreen_screenId(UUID movieTheatreId);
}
