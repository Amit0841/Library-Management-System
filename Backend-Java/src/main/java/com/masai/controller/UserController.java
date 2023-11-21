package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Users;
import com.masai.service.UserServiceInterface;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserServiceInterface serviceInterface;
	
@PostMapping("/users")
ResponseEntity<Users> registeruser(@Valid @RequestBody Users user){
	
	return new ResponseEntity<Users>(serviceInterface.addUsers(user),HttpStatus.CREATED);
}
}
