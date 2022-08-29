package com.infosys.com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.com.dto.SearchFlights;
import com.infosys.com.entity.Flight;
import com.infosys.com.repository.FlightsRepository;;

@Service
public class FlightService {

	@Autowired
	private FlightsRepository flightsRepository;

	public List<String> getSources() throws Exception {
		List<String> sources = flightsRepository.findFlightSources();
		if (sources == null) {
			throw new Exception("No details available");
		} else {
			return sources;
		}
	}
	
	public void updateFlight(String flightId, int noOfSeats) throws Exception {
		Flight flight = flightsRepository.findById(flightId).get();

		if (flight == null) {
			throw new Exception("No flight exists");
		} else {

			int count = flight.getSeatCount() - Integer.valueOf(noOfSeats);
			flight.setSeatCount(count);
			flightsRepository.saveAndFlush(flight);

		}

	}

	public List<String> getDestinationss() throws Exception {
		List<String> destinations = flightsRepository.findFlightDestinations();
		if (destinations == null) {
			throw new Exception("No record found");
		} else {
			return destinations;
		}
	}

	public List<SearchFlights> getFlights(String source, String destination, Date date) {

		List<Flight> flights = flightsRepository.findFlightDetails(source, destination, date);

		List<SearchFlights>  totalFlights= new ArrayList<SearchFlights>();
		for (Flight f : flights) {
			SearchFlights flight = new SearchFlights();
			flight.setFlightId(f.getFlightId());
			flight.setArrivalTime(f.getArrivalTime());
			flight.setFare(Double.toString(f.getFare()));
			flight.setSource(f.getSource());
			flight.setDestination(f.getDestination());
			flight.setDepartureTime(f.getDepartureTime());
			flight.setSeatCount(f.getSeatCount().toString());
			flight.setAirlines(f.getAirlines());
			flight.setJourneyDate(f.getFlightAvailableDate());
			totalFlights.add(flight);
		}

		return totalFlights;

	}

	public Flight getFlights(String flightId) {
		return flightsRepository.findById("F101").get();

	}

}
