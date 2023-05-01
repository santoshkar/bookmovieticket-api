package com.santosh.assessment.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.BookingMaster;

public interface ApiServiceMaster extends JpaRepository<BookingMaster, UUID> {
	List<BookingMaster> findByShow_showIdAndBookingStatusIn(UUID showId, String... statusList);
}
