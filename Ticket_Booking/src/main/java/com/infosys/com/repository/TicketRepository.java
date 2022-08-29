package com.infosys.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infosys.com.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Double> {

}
