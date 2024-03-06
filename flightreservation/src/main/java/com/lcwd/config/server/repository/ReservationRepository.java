package com.lcwd.config.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.config.server.entities.Reservation;

public interface ReservationRepository extends JpaRepository<com.lcwd.config.server.entities.Reservation, Long>{

	Reservation findOne(Long id);

}
