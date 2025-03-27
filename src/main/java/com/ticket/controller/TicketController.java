package com.ticket.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ticket.entity.Ticket;
import com.ticket.entity.TicketMaps;
import com.ticket.entity.TicketPriority;
import com.ticket.entity.TicketStatus;
import com.ticket.entity.User;
import com.ticket.repository.TicketPriorityRepository;
import com.ticket.repository.TicketRepository;
import com.ticket.repository.TicketStatusRepository;
import com.ticket.repository.UserRepository;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"}) 
public class TicketController {
	@Autowired
	TicketRepository ticketRepositoryObj;
	
	@Autowired
	TicketStatusRepository ticketStatusRepositoryObj;
	
	@Autowired
	TicketPriorityRepository ticketPriorityRepositoryObj;
	
	@Autowired
	UserRepository userRepositoryObj;
	
	@GetMapping()
	public List<Ticket> getAllTickets(){
		return ticketRepositoryObj.findAll();
	
	}
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ticket createTicket(@RequestBody TicketMaps ticketMaps) {
	    Ticket ticket = new Ticket();
	    ticket.setTicket_title(ticketMaps.getTicket_title());
	    ticket.setTicket_description(ticketMaps.getTicket_description());
	    ticket.setTicket_comment(ticketMaps.getTicket_comment());
	    ticket.setTicket_deleted(false);
	    
	    User createdBy = new User();
	    createdBy.setUser_id(ticketMaps.getTicket_createdBy());
	    ticket.setTicket_createdBy(createdBy);
	    
	    User assignedTo = new User();
	    assignedTo.setUser_id(ticketMaps.getTicket_assignedTo());
	    ticket.setTicket_assignedTo(assignedTo);
	    
	    TicketPriority priority = new TicketPriority();
	    priority.setTicketPriority_id(ticketMaps.getTicketPriority_id());
	    ticket.setTicket_priority(priority);
	    
	    TicketStatus status = new TicketStatus();
	    status.setTicketStatus_id(ticketMaps.getTicketStatus_id());
	    ticket.setTicket_status(status);
	    ticketRepositoryObj.save(ticket);
	    return ticket;
	}
	@PutMapping("/{ticket_id}")
	public Ticket updateTicket(
	    @PathVariable Long ticket_id,
	    @RequestBody TicketMaps ticketMaps
	) {
	    Ticket ticket = ticketRepositoryObj.findById(ticket_id)
	        .orElseThrow(() -> new RuntimeException("Ticket not found"));

	    // Update basic fields (assumes all fields are provided)
	    ticket.setTicket_title(ticketMaps.getTicket_title());
	    ticket.setTicket_description(ticketMaps.getTicket_description());
	    ticket.setTicket_comment(ticketMaps.getTicket_comment());
	    ticket.setTicket_modifiedDate(LocalDateTime.now());

	    // Update relationships (IDs only, assumes all are provided)
	    User createdBy = new User();
	    createdBy.setUser_id(ticketMaps.getTicket_createdBy());
	    ticket.setTicket_createdBy(createdBy);

	    User assignedTo = new User();
	    assignedTo.setUser_id(ticketMaps.getTicket_assignedTo());
	    ticket.setTicket_assignedTo(assignedTo);

	    TicketPriority priority = new TicketPriority();
	    priority.setTicketPriority_id(ticketMaps.getTicketPriority_id());
	    ticket.setTicket_priority(priority);

	    TicketStatus status = new TicketStatus();
	    status.setTicketStatus_id(ticketMaps.getTicketStatus_id());
	    ticket.setTicket_status(status);

	    return ticketRepositoryObj.save(ticket);
	}
	
	@DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable Long id) {
		ticketRepositoryObj.deleteById(id);
    }

}
