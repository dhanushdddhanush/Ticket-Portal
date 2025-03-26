package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.TicketPriority;
import com.ticket.repository.TicketPriorityRepository;


@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"})
public class TicketPriorityController {
	@Autowired
	TicketPriorityRepository ticketPriorityRepositoryObj;
	@GetMapping("/ticketpriority")
	public List<TicketPriority> getAllTickets(){
		return ticketPriorityRepositoryObj.findAll();
	
	}

}
