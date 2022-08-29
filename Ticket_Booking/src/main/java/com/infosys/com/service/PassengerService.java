package com.infosys.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.com.dto.PassengerDetails;
import com.infosys.com.entity.Passenger;
import com.infosys.com.repository.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	public void createPassenger(List<Passenger> passengers) {

		passengerRepository.saveAll(passengers);

	}
	
}
