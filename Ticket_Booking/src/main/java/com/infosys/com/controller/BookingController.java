package com.infosys.com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.com.dto.BookingDetails;
import com.infosys.com.dto.PassengerDetails;
import com.infosys.com.entity.Flight;
import com.infosys.com.entity.Passenger;
import com.infosys.com.entity.Ticket;
import com.infosys.com.exception.Exception;
import com.infosys.com.service.FlightService;
import com.infosys.com.service.PassengerService;
import com.infosys.com.service.TicketService;


@RestController
@RequestMapping("/book")
public class BookingController {

	@Autowired
	private FlightService flightService;	
	@Autowired
	private TicketService ticketService;
	@Autowired
	private PassengerService passengerService;
	private Ticket ticket;
	private int noOfSeats;
	

	public BookingController() {
		ticket = new Ticket();		
	}

	private void addPassengers(List<Passenger> passengers) {
		
		for (Passenger passenger : passengers) {
			passenger.setTicket(ticket);	    

		}
		passengerService.createPassenger(passengers);

	}

	@PostMapping(value = "/{flightId}/{username}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BookingDetails> bookFlight(@PathVariable String flightId,
		 @Valid @RequestBody PassengerDetails passengerDetails, @PathVariable String username,Errors errors) throws Exception, Exception {
			
		    if (errors.hasErrors()) {
			return new ResponseEntity(new Error(HttpStatus.BAD_REQUEST.value(),errors.getFieldError("passengerList").getDefaultMessage()), HttpStatus.BAD_REQUEST);
		    }
		if(passengerDetails.getPassengerList().isEmpty())
        	throw new Exception("List is Empty");
        	
		List<Passenger> passengerList = new ArrayList<Passenger>();
		for (Passenger passengers : passengerDetails.getPassengerList()) {
			passengerList.add(passengers);
		    

		}

		int pnr = (int) (Math.random() * 1952412);

		ticket.setPnr(pnr);
          
		Flight flight = flightService.getFlights(flightId);

		double fare = flight.getFare();
		double totalFare = fare * (passengerDetails.getPassengerList().size());

		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setPassengerList(passengerDetails.getPassengerList());
		bookingDetails.setPnr(pnr);
		bookingDetails.setTotalFare(totalFare);
		ticket.setBookingDate(new Date());
		ticket.setFlightId(flight.getFlightId());
		ticket.setUserId(username);	
		ticket.setDepartureDate(flight.getFlightAvailableDate());
		ticket.setDepartureTime(flight.getDepartureTime());
		ticket.setTotalFare(totalFare);
		noOfSeats = passengerDetails.getPassengerList().size();
		ticket.setNoOfSeats(noOfSeats);
	    ticketService.createTicket(ticket);
    
		addPassengers(bookingDetails.getPassengerList());
		
		flightService.updateFlight(flightId, noOfSeats);

		return new ResponseEntity<BookingDetails>(bookingDetails, HttpStatus.OK);

	}

}
