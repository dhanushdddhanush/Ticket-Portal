package com.ticket.entity;

import io.swagger.v3.oas.annotations.media.Schema;

public class TicketMaps {
    @Schema(description = "Title of the Ticket")
	 private String ticket_title;
    @Schema(description = "Description of the Ticket")
	 private String ticket_description;
    @Schema(description = "Ticket created by which user")
	 private Long ticket_createdBy;
    @Schema(description = "Priority of the Ticket")
	 private Long ticketPriority_id;
	 @Schema(description = "Assigned To which user")
	 private Long ticket_assignedTo;
	  @Schema(description = "Status of the Ticket")
	 private Long ticketStatus_id;
	  @Schema(description = "Comment for the Ticket")
	 private String ticket_comment;
	public String getTicket_title() {
	return ticket_title;
	}
	public void setTicket_title(String ticket_title) {
		this.ticket_title = ticket_title;
	}
	public String getTicket_description() {
		return ticket_description;
	}
	public void setTicket_description(String ticket_description) {
		this.ticket_description = ticket_description;
	}
	public Long getTicket_createdBy() {
		return ticket_createdBy;
	}
	public void setTicket_createdBy(Long ticket_createdBy) {
		this.ticket_createdBy = ticket_createdBy;
	}
	public Long getTicketPriority_id() {
		return ticketPriority_id;
	}
	public void setTicketPriority_id(Long ticketPriority_id) {
		this.ticketPriority_id = ticketPriority_id;
	}
	public Long getTicket_assignedTo() {
		return ticket_assignedTo;
	}
	public void setTicket_assignedTo(Long ticket_assignedTo) {
		this.ticket_assignedTo = ticket_assignedTo;
	}
	public Long getTicketStatus_id() {
		return ticketStatus_id;
	}
	public void setTicketStatus_id(Long ticketStatus_id) {
		this.ticketStatus_id = ticketStatus_id;
	}
	public String getTicket_comment() {
		return ticket_comment;
	}
	public void setTicket_comment(String ticket_comment) {
		this.ticket_comment = ticket_comment;
	}
	 
	 

}
