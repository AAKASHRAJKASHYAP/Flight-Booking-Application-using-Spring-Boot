package com.lcwd.config.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.config.server.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
