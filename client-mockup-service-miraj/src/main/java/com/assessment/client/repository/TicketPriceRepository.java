package com.assessment.client.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.client.entity.TicketPrice;

public interface TicketPriceRepository extends JpaRepository<TicketPrice, UUID> {
	TicketPrice findByScreenId(String screenId);
}
