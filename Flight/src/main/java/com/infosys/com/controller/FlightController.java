package com.infosys.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.com.dto.SearchFlights;
import com.infosys.com.entity.Flight;
import com.infosys.com.service.FlightService;
import com.infosys.com.utility.MyDateEditor;

@RestController
@RequestMapping("/flights")

	@Autowired
	private FlightService flightService;

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new MyDateEditor(format));
	}

	@GetMapping("/{flightId}")
	public Flight getFlights(@PathVariable("flightId") String flightId) throws Exception {
		System.out.println("flight id" + flightId);
		return flightService.getFlights(flightId);
	}

	@GetMapping("/sources")
	public List<String> getFlightSources() throws Exception {
		System.out.println("In get sources");
		return flightService.getSources();
	}

	@GetMapping("/destinations")
	public List<String> getFlightDestinations() throws Exception {
		System.out.println("In get sources");
		return flightService.getDestinationss();
	}

	@RequestMapping(value = "/{flightId}/{noOfSeats}")
			throws Exception {
		flightService.updateFlight(flightId, noOfSeats);

	}
	
	@GetMapping("/{source}/{destination}/{journeyDate}")
	public ResponseEntity<List<SearchFlights>> getFlightDetails(@PathVariable String source,
			HttpServletResponse response, @PathVariable String destination, @PathVariable Date journeyDate) {
		List<SearchFlights> availableFlights = flightService.getFlights(source, destination, journeyDate);
		return new ResponseEntity<List<SearchFlights>>(availableFlights, HttpStatus.OK);

	}
}