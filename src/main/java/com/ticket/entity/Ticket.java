package com.ticket.entity;
import java.time.LocalDateTime;

import javax.persistence.*;
@Entity
@Table(name="ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false, unique=true)
	private String title;
	 @Column( nullable=false)
	 private String description;
	 @ManyToOne
	 @JoinColumn(name="priorityId", nullable=false)
	 private TicketPriority priorityId;
	 @ManyToOne
	 @JoinColumn(name="statusId", nullable=false)
	 private TicketStatus statusId ;
	 @ManyToOne
	 @JoinColumn(name="createdBy" , nullable=false)
	 private User createdBy;
	 @Column( nullable=false)
	 private LocalDateTime createdDate;
	 @Column(name="modifiedDate")
	 private LocalDateTime modifiedDate;
	 @ManyToOne
	 @JoinColumn(name="assignedTo",nullable=false)
	private User assignedTo;
	 @Column(nullable=false)
	 private String comment;
	 @Column(nullable=false)
	 private Boolean isDeleted;
	 @Column(name="deletedData")
	 private LocalDateTime deletedDate;
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TicketPriority getPriorityId() {
		return priorityId;
	}
	public void setPriorityId(TicketPriority priorityId) {
		this.priorityId = priorityId;
	}
	public TicketStatus getStatusId() {
		return statusId;
	}
	public void setStatusId(TicketStatus statusId) {
		this.statusId = statusId;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public User getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public LocalDateTime getDeletedDate() {
		return deletedDate;
	}
	public void setDeletedDate(LocalDateTime deletedDate) {
		this.deletedDate = deletedDate;
	}
}