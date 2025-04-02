package com.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticket.entity.Role;
import com.ticket.entity.User;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByUser(User user);
}
