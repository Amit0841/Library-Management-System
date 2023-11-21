package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Users;
import com.masai.repository.UserRepository;

@org.springframework.stereotype.Service
public class UserService implements UserServiceInterface{
	@Autowired
private UserRepository userRepository;
	
	@Override
	public Users addUsers(Users user) {
		userRepository.save(user);
		return user;
	}

}
