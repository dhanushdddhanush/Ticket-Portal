package com.ticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.Role;
import com.ticket.entity.User;
import com.ticket.entity.UserInfo;
import com.ticket.entity.UserRoles;
import com.ticket.repository.RoleRepository;
import com.ticket.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
/**
 * REST Controller for handling user-related operations.
 * Provides CRUD functionality for users including creation, getting,
 * and deletion of user .
 * 
 * Cross-origin requests are allowed from specified frontend urls.
 */
@RestController
@RequestMapping("/user")

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"}) 

@Tag(name="User Controller", description="APIs for user table here we have GET,POST,PUT,DELETE call of users ")

public class UserController {
	@Autowired
	UserRepository userRepositoryObj;
	@Autowired
	RoleRepository roleRepositoryObj;
	 /**
     * Retrieves all users.
     * 
     * @return List of all User with their associated roles
     * @throws RuntimeException if no users are found
     */
	@Operation(summary = "Get operation for users", description = "Get call for fetching all users")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	
	 @GetMapping()
    public List<User> getAllUsers() {
        return userRepositoryObj.findAll();
    }
	@GetMapping("/basic-info")
	public List<UserInfo> getBasicUserInfo() {
	    List<User> users = userRepositoryObj.findAll();
	    List<UserInfo> result = new ArrayList<>();
	    
	    for (User user : users) {
	        result.add(new UserInfo(
	            user.getUser_id(),
	            user.getUserName(),
	            user.getName()
	        ));
	    }
	    
	    return result;
	}
	/**
     * Creates a new user with role.
     * 
     * @param userRoles DTO containing user information .
     * @return The newly created User .
     * @throws RuntimeException if required fields are missing or invalid
     */
	@Operation(summary = "Post operation for users", description = "post call for adding new  users")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	
	 @PostMapping("/add")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public User createUser(@RequestBody UserRoles userRoles) {
	        User user = new User();
	        user.setUserName(userRoles.getUserName());
	        user.setPassword(userRoles.getPassword());
	        user.setName(userRoles.getName());
	        user.setEmail(userRoles.getEmail());
	        user.setPhone(userRoles.getPhone());
	        user.setDepartment(userRoles.getDepartment());
	        user = userRepositoryObj.save(user);
	        Role role = new Role(user, userRoles.getRole());
	        roleRepositoryObj.save(role);
	        return user;
	    }
	@Operation(summary = "Delete operation for users", description = "Delete call for deleting users")
	@ApiResponse(responseCode = "200", description = "found", content = @Content(schema = @Schema(implementation = String.class)))
	@ApiResponse(responseCode = "404", description = "Method not found")
	@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
	/**
     * Deletes a user .
     * 
     * @param id The ID of the user to delete
     * @throws RuntimeException if user with given ID is not found
     */
	@DeleteMapping("/user/delete/{id}")
    public void removeUser(@PathVariable Long id) {
		userRepositoryObj.deleteById(id);
    }
}
