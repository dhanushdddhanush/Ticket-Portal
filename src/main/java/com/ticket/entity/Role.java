package com.ticket.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id for the 	Role")
    @Column(name = "roles_id")
    private Long roles_id;
    @Schema(description = "UserId  Foreign key for the user")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
    private User user;
    @Schema(description = "Roles available for the role table")
    @Column(nullable = false)
    private String role;
    
    public Role(User user,String role) {
    	this.user = user;
    	this.role = role;
    }
	public Long getRoles_id() {
		return roles_id;
	}
	public void setRoles_id(Long roles_id) {
		this.roles_id = roles_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 public Role() {
	    }
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	


}