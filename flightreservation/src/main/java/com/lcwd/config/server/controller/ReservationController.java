package com.lcwd.config.server.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcwd.config.server.dto.ReservationRequest;
import com.lcwd.config.server.entities.Flight;
import com.lcwd.config.server.entities.Reservation;
import com.lcwd.config.server.repository.FlightRepository;
import com.lcwd.config.server.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap)
	{
		Optional<Flight>flightOptional=flightRepository.findById(flightId);
		 if (flightOptional.isPresent()) {
		        Flight flight = flightOptional.get();
		        modelMap.addAttribute("flight", flight);
		    }
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap)
	{
		Reservation reservation=reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservation created successfully and the id is"+reservation.getId());
		return  "reservationConfirmation";
	}
}
