package com.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.TicketStatus;
import com.ticket.repository.TicketStatusRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * REST Controller for managing ticket status values.
 * Cross-origin requests are allowed from specified frontend urls.
 */
@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"})
@Tag(name="Ticket Status Controller", description="APIs for ticket status table here we have GET call of  ticket status")

public class TicketStatusController {
	@Autowired
	TicketStatusRepository ticketStatusRepositoryObj;
	/**
     * Retrieves all available ticket status options..
     * 
     * @return List of all TicketStatus options
     * @throws RuntimeException if no status values are configured in the database
     */
	@Operation(summary = "Get operation for ticket status", description = "Get call for fetching ticket status")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	@GetMapping("/ticketstatus")
	public List<TicketStatus> getAllTickets(){
		return ticketStatusRepositoryObj.findAll();
	
	}

}
