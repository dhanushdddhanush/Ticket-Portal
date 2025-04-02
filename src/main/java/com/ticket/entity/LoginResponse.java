package com.ticket.entity;

import io.swagger.v3.oas.annotations.media.Schema;

public class LoginResponse {
    @Schema(description = "User ID")
    private Long userId;
    
    @Schema(description = "User's name")
    private String name;
    
    @Schema(description = "User's email")
    private String email;
    
    @Schema(description = "User's role (admin/user)")
    private String role;

   
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}