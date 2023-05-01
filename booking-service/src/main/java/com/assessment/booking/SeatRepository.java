package com.assessment.booking;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
	List<Seat> findByScreen_screenId(UUID movieTheatreId);
}
