package com.ticket.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.entity.User;
import com.ticket.repository.UserRepository;
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	UserRepository repo;
	
	 @GetMapping()
    public List<User> getAllUsers() {
        return repo.findAll();
    }
	 
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createuser(@RequestBody User user) {
		repo.save(user);
	}
}
