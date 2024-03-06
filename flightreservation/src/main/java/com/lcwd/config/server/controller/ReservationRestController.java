package com.lcwd.config.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.config.server.dto.ReservationUpdateRequest;
import com.lcwd.config.server.entities.Reservation;
import com.lcwd.config.server.repository.ReservationRepository;

//@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	@RequestMapping("reservation/{id}")
	public Reservation findReservation(@PathVariable("id")Long id)
	{
		return reservationRepository.findOne(id);	
	}
	
//	@RequestMapping("/reservations")
//	public Reservation updateReservatio(@RequestBody ReservationUpdateRequest req)
//	{
//		Reservation reservation=reservationRepository.findOne(req.getId());
//		reservation.setNumberOfBags(req.getNumberOfBags());
//		reservation.setCheckedIn(req.isCheckedIn());
//		Reservation updatedReservation=reservationRepository.save(reservation);
//		return updatedReservation;
//	}
	
}
