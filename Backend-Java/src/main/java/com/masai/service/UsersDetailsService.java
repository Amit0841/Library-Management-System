package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.Users;
import com.masai.repository.UserRepository;

@Service
public class UsersDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository customerRepositry;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Users> user = customerRepositry.findByEmail(username) ;
		if(user.isEmpty()) throw new UsernameNotFoundException("user not found") ;
		Users us = user.get() ;
		List<GrantedAuthority> authorities = new ArrayList<>() ;
		SimpleGrantedAuthority autho = new SimpleGrantedAuthority("ROLE_"+us.getRole().toUpperCase()) ;
		authorities.add(autho) ;
		org.springframework.security.core.userdetails.User secUser = new org.springframework.security.core.userdetails.User(us.getEmail(), us.getPassword(),  authorities) ;
		return secUser ;

	
	}

}
