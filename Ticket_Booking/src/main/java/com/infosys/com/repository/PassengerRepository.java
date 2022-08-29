package com.infosys.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.com.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

}
