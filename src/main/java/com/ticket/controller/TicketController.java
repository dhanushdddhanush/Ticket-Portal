package com.ticket.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
/**
 * REST Controller for handling ticket-related operations.
 * Provides CRUD functionality for tickets including creation, getting,
 * updating, and deletion of tickets.
 * 
 * Cross-origin requests are allowed from specified frontend urls.
 */
@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"}) 
@Tag(name="TicketController", description="API for GET, POST, PUT , DELETE  for Tickets")

public class TicketController {
	@Autowired
	TicketRepository ticketRepositoryObj;
	
	@Autowired
	TicketStatusRepository ticketStatusRepositoryObj;
	
	@Autowired
	TicketPriorityRepository ticketPriorityRepositoryObj;
	 /**
     * Retrieves all tickets from the database.
     * 
     * @return List of all Tickets
     * @throws RuntimeException if no tickets are found
     */
	@Autowired
	UserRepository userRepositoryObj;
	@Operation(summary = "Get operation for tickets", description = "Get call for fetching tickets")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	@GetMapping()
	public List<Ticket> getAllTickets(){
		return ticketRepositoryObj.findAllActiveTickets();
	
	}
	 @GetMapping("/my-tickets/{userId}")
	    public List<Ticket> getTicketsForUser(@PathVariable Long userId) {
	        return ticketRepositoryObj.findByCreatedByOrAssignedTo(userId)
	               .stream()
	               .filter(ticket -> !ticket.getTicket_deleted())  // Exclude deleted tickets for users
	               .collect(Collectors.toList());
	    }
	 @GetMapping("/admin/all-tickets")
	 public List<Ticket> getAllTicketsForAdmin() {
	     return ticketRepositoryObj.findAllTicketsIncludingDeleted();
	 }

	/**
     * Retrieves a specific ticket by its ID.
     * 
     * @param ticket_id The ID of the ticket to retrieve
     * @return The requested Ticket specific id
     * @throws RuntimeException if ticket with given ID is not found
     */
	@Operation(summary = "Get ticket by specific id", description = "Get call for fetching specific ticket with id")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	@GetMapping("/{ticket_id}")
	public Ticket getTicketById(@PathVariable Long ticket_id) {
	    return ticketRepositoryObj.findById(ticket_id)
	        .orElseThrow(() -> new RuntimeException("Ticket not found"));
	}
	/**
     * Creates a new ticket via post call.
     * 
     * @param ticketMaps DTO containing ticket information
     * @return The new created Ticket 
     * @throws RuntimeException if required fields are missing or invalid
     */
	@Operation(summary = "Post operation for ticket", description = "Post call for adding tickets")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
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
	/**
     * Updates an existing ticket with post call.
     * 
     * @param ticket_id The ID of the ticket to update
     * @param ticketMaps DTO containing updated ticket information
     * @return The updated Ticket 
     * @throws RuntimeException if ticket with given ID is not found
     */
	@Operation(summary = "Put operation for ticket", description = "Put call for editing tickets")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	@PutMapping("/{ticket_id}")
	public Ticket updateTicket(
	    @PathVariable Long ticket_id,
	    @RequestBody TicketMaps ticketMaps
	) {
	    Ticket ticket = ticketRepositoryObj.findById(ticket_id)
	        .orElseThrow(() -> new RuntimeException("Ticket not found"));

	   
	    ticket.setTicket_title(ticketMaps.getTicket_title());
	    ticket.setTicket_description(ticketMaps.getTicket_description());
	    ticket.setTicket_comment(ticketMaps.getTicket_comment());
	    ticket.setTicket_modifiedDate(LocalDateTime.now());

	  
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
	 /**
     * Deletes a ticket  via Delete call.
     * 
     * @param id The ID of the ticket to delete
     * @throws RuntimeException if ticket with given ID is not found
     */
	@Operation(summary = "Delete operation for ticket", description = "Delete call for Deleting tickets")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	
	@DeleteMapping("/delete/{id}")
	public void removeTicket(@PathVariable Long id) {
	    Ticket ticket = ticketRepositoryObj.findById(id)
	        .orElseThrow(() -> new RuntimeException("Ticket not found"));
	    
	    // Soft delete - mark as deleted and set deletion timestamp
	    ticket.setTicket_deleted(true);
	    ticket.setTicket_deletedDate(LocalDateTime.now());
	    
	    ticketRepositoryObj.save(ticket);
	}

}
