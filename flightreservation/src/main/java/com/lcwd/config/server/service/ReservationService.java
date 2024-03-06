package com.lcwd.config.server.service;

import com.lcwd.config.server.dto.ReservationRequest;
import com.lcwd.config.server.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
	
}
