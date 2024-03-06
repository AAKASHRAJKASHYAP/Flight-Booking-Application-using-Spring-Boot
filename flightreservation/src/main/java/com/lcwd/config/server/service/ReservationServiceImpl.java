package com.lcwd.config.server.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.config.server.dto.ReservationRequest;
import com.lcwd.config.server.entities.Flight;
import com.lcwd.config.server.entities.Passenger;
import com.lcwd.config.server.entities.Reservation;
import com.lcwd.config.server.repository.FlightRepository;
import com.lcwd.config.server.repository.PassengerRepository;
import com.lcwd.config.server.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequest request)
	{
		Long flightId=request.getFlightId();
		Optional<Flight> Optflight=flightRepository.findById(flightId);
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savePassenger=passengerRepository.save(passenger);
		
		Reservation reservation=new Reservation();
		Flight flight=null;
		if(Optflight.isPresent())
		{
			flight=Optflight.get();
			reservation.setFlight(flight);
		}
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);
		Reservation saveReservation=reservationRepository.save(reservation);
		return saveReservation;
	}
}
