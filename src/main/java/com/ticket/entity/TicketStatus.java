package com.ticket.entity;
import javax.persistence.*;

import io.swagger.v3.oas.annotations.media.Schema;
@Entity
@Table(name="ticketStatus")
public class TicketStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Schema(description = "Id for the ticketstatus")
	private Long ticketStatus_id;
	 @Schema(description = "Description for the ticketstatus")
	@Column(nullable=false)
	private String ticketStatus_description;
	public Long getTicketStatus_id() {
		return ticketStatus_id;
	}
	public void setTicketStatus_id(Long ticketStatus_id) {
		this.ticketStatus_id = ticketStatus_id;
	}
	public String getTicketStatus_description() {
		return ticketStatus_description;
	}
	public void setTicketStatus_description(String ticketStatus_description) {
		this.ticketStatus_description = ticketStatus_description;
	}
	
	

}
