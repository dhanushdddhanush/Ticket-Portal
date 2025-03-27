package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.TicketPriority;
import com.ticket.repository.TicketPriorityRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller for handling ticket priority related operations.
 * 
 * Cross-origin requests are allowed from specified frontend urls.
 */
@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"})
@Tag(name="Ticket Priority Controller", description="APIs for ticket priority table here we have GET call of priorities ")

public class TicketPriorityController {
	@Autowired
	TicketPriorityRepository ticketPriorityRepositoryObj;
	 /**
     * Retrieves all available ticket priority options.
     * 
     * @return List of all TicketPriority options
     * @throws RuntimeException if no priorities are found in the database
     */
	@Operation(summary = "Get operation for ticket priority", description = "Get call for fetching ticket priorities")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	@GetMapping("/ticketpriority")
	public List<TicketPriority> getAllTickets(){
		return ticketPriorityRepositoryObj.findAll();
	
	}

}
