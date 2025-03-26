package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.entity.TicketPriority;
@Repository
public interface TicketPriorityRepository extends JpaRepository<TicketPriority, Long> {

}
