package com.santosh.assessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.TicketPrice;

public interface TicketPriceRepository extends JpaRepository<TicketPrice, UUID> {
	TicketPrice findByMovieScreening_id(UUID movieScreeningId);
}
