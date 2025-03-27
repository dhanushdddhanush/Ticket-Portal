package com.ticket.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
@Entity
@Table(name="ticketPriority")
public class TicketPriority {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Schema(description = "Id for the ticket Priority")
 private Long ticketPriority_id;
 @Schema(description = "Description for the Priority")
 @Column(nullable=false)
 private String  ticketPriority_description;
public Long getTicketPriority_id() {
	return ticketPriority_id;
}
public void setTicketPriority_id(Long ticketPriority_id) {
	this.ticketPriority_id = ticketPriority_id;
}
public String getTicketPriority_description() {
	return ticketPriority_description;
}
public void setTicketPriority_description(String ticketPriority_description) {
	this.ticketPriority_description = ticketPriority_description;
}
 
 
 

}
