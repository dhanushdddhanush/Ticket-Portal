package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.Ticket;
import com.ticket.repository.TicketRepository;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	TicketRepository repo;
	@GetMapping()
	public List<Ticket> getAllTickets(){
		return repo.findAll();
	
	}


}
