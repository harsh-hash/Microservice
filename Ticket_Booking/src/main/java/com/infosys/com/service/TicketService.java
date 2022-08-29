package com.infosys.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.com.entity.Ticket;
import com.infosys.com.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public void createTicket(Ticket ticket) {

		ticketRepository.saveAndFlush(ticket);

	}

}
