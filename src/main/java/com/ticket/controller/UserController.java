package com.ticket.controller;

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
import com.ticket.entity.UserRoles;
import com.ticket.repository.RoleRepository;
import com.ticket.repository.UserRepository;

@RequestMapping("/user")

@CrossOrigin(origins = {"http://localhost:5173","http://localhost:5174"}) 
@RestController
public class UserController {
	@Autowired
	UserRepository userRepositoryObj;
	@Autowired
	RoleRepository roleRepositoryObj;
	
	 @GetMapping()
    public List<User> getAllUsers() {
        return userRepositoryObj.findAll();
    }
	 
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
	@DeleteMapping("/user/delete/{id}")
    public void removeUser(@PathVariable Long id) {
		userRepositoryObj.deleteById(id);
    }
}
