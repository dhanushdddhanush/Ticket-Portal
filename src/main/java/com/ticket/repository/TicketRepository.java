package com.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ticket.entity.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	@Query("SELECT t FROM Ticket t WHERE t.ticket_createdBy.user_id = :userId OR t.ticket_assignedTo.user_id = :userId")
	List<Ticket> findByCreatedByOrAssignedTo(@Param("userId") Long userId);
	@Query("SELECT t FROM Ticket t WHERE t.ticket_deleted = false")
	List<Ticket> findAllActiveTickets();
	@Query("SELECT t FROM Ticket t")
	List<Ticket> findAllTicketsIncludingDeleted();
	@Query("SELECT t FROM Ticket t WHERE (t.ticket_createdBy.user_id = :userId OR t.ticket_assignedTo.user_id = :userId) AND t.ticket_deleted = false")
	List<Ticket> findActiveTicketsForUser(@Param("userId") Long userId);


}
