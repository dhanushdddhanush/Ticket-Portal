package com.ticket.entity;
import javax.persistence.*;
@Entity
@Table(name="ticketPriority")
public class TicketPriority {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long ticketPriority_id;
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
