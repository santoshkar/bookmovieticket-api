package com.assessment.client.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.client.entity.BookingMaster;

public interface BookingRepository extends JpaRepository<BookingMaster, UUID> {
	List<BookingMaster> findByShow_showIdAndBookingStatusIn(UUID showId, String... statusList);
}
