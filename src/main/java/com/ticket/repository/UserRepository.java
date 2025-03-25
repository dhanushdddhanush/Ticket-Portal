package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticket.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

}
