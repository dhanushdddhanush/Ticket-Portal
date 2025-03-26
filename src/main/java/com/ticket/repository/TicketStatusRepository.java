package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.entity.TicketStatus;
@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long> {

}
