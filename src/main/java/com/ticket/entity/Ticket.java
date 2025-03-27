package com.ticket.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id for the ticket")
    private Long ticket_id;
    @Schema(description = "Title for the ticket")
    @Column(nullable=false)
    private String ticket_title;
    @Schema(description = "Description for the ticket")
    @Column(nullable=false)
    private String ticket_description;
    @Schema(description = "Foreign key Relation Ticket Priority Table to Ticket table")
    
    @ManyToOne
    @JoinColumn(name="priorityId", nullable=false)
    private TicketPriority ticket_priority;
    @Schema(description = "Foreign key Relation Ticket Status table to Ticket table")
    @ManyToOne
    @JoinColumn(name="statusId", nullable=false)
    private TicketStatus ticket_status;
    @Schema(description = "Foreign key Relation CreatedBy to user table")
    
    @ManyToOne
    @JoinColumn(name="createdBy", nullable=false)
    private User ticket_createdBy;
    @Schema(description = "Adding Local Time Stamp")
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime ticket_createdDate = LocalDateTime.now();
    
    @Schema(description = "Updating modifiedDate When Updated")
    
    @Column(name="modifiedDate", nullable=true)
    private LocalDateTime ticket_modifiedDate;
    @Schema(description = "Foreign key Relation assignedTo to user table")
    @ManyToOne
    @JoinColumn(name="assignedTo", nullable=false)
    private User ticket_assignedTo;
    @Schema(description = "Adding Ticket Comments")
    @Column(nullable=false)
    private String ticket_comment;
    @Schema(description = "Ticket Deleted Or Not")
    @Column(nullable=false)
    private Boolean ticket_deleted = false;
    @Schema(description = " When Ticket Deleted Time Stamp")
    @Column(name="deletedDate", nullable=true)
    private LocalDateTime ticket_deletedDate;

	public Long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Long ticket_id) {
		this.ticket_id = ticket_id;
	}

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

	public TicketPriority getTicket_priority() {
		return ticket_priority;
	}

	public void setTicket_priority(TicketPriority ticket_priority) {
		this.ticket_priority = ticket_priority;
	}

	public TicketStatus getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(TicketStatus ticket_status) {
		this.ticket_status = ticket_status;
	}

	public User getTicket_createdBy() {
		return ticket_createdBy;
	}

	public void setTicket_createdBy(User ticket_createdBy) {
		this.ticket_createdBy = ticket_createdBy;
	}

	public LocalDateTime getTicket_createdDate() {
		return ticket_createdDate;
	}

	public void setTicket_createdDate(LocalDateTime ticket_createdDate) {
		this.ticket_createdDate = ticket_createdDate;
	}

	public LocalDateTime getTicket_modifiedDate() {
		return ticket_modifiedDate;
	}

	public void setTicket_modifiedDate(LocalDateTime ticket_modifiedDate) {
		this.ticket_modifiedDate = ticket_modifiedDate;
	}

	public User getTicket_assignedTo() {
		return ticket_assignedTo;
	}

	public void setTicket_assignedTo(User ticket_assignedTo) {
		this.ticket_assignedTo = ticket_assignedTo;
	}

	public String getTicket_comment() {
		return ticket_comment;
	}

	public void setTicket_comment(String ticket_comment) {
		this.ticket_comment = ticket_comment;
	}

	public Boolean getTicket_deleted() {
		return ticket_deleted;
	}

	public void setTicket_deleted(Boolean ticket_deleted) {
		this.ticket_deleted = ticket_deleted;
	}

	public LocalDateTime getTicket_deletedDate() {
		return ticket_deletedDate;
	}

	public void setTicket_deletedDate(LocalDateTime ticket_deletedDate) {
		this.ticket_deletedDate = ticket_deletedDate;
	}

}