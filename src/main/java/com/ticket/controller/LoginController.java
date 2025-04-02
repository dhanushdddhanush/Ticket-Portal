package com.ticket.controller;

import com.ticket.entity.LoginRequest;
import com.ticket.entity.LoginResponse;
import com.ticket.entity.Role;
import com.ticket.entity.User;
import com.ticket.repository.RoleRepository;
import com.ticket.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"})
@Tag(name="Authentication Controller", description="APIs for user authentication")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;

    @Operation(summary = "User login", description = "Verify user credentials and return role information")
    @ApiResponse(responseCode = "200", description = "Login successful", 
                 content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "401", description = "Unauthorized - invalid credentials")
    @ApiResponse(responseCode = "404", description = "User not found")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        // Find user by email
        User user = userRepository.findByEmail(loginRequest.getEmail());
        
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }
        
        // Verify password (in real application, use password encoder)
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        
        // Get user role
        Role role = roleRepository.findByUser(user);
        if (role == null) {
            return ResponseEntity.status(401).body("No role assigned to user");
        }
        
        // Create response with user and role information
        LoginResponse response = new LoginResponse();
        response.setUserId(user.getUser_id());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(role.getRole());
        
        return ResponseEntity.ok(response);
    }
}