package com.infosys.com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.infosys.com.entity.Flight;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, String> {

	@Query("select f from Flight f where f.source=:source and f.destination=:destination and f.flightAvailableDate=:date")
	List<Flight> findFlightDetails(@Param String source, @Param String destination,
			@Param Date date);
	
	@Query("select f.source from Flight f")
	List<String> findFlightSources();

	@Query("select f from Flight f where f.flightId=:flightId")
	Flight findFlight(@Param String flightId);


	@Query("select f.destination from Flight f")
	List<String> findFlightDestinations();

}
