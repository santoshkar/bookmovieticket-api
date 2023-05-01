package com.assessment.booking;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingMaster, UUID> {
	List<BookingMaster> findByShowIdAndBookingStatusIn(UUID showId, String... statusList);
}
