package com.santosh.assessment.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.assessment.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, UUID> {
//	TicketPriceMaster movieTheatreScreen_theatre_id(UUID movieTheatreId);
//	TicketPriceMaster findByMovieTheatre_movie_idAndMovieTheatre_theatre_id(UUID movieId, UUID theatreId);
}
