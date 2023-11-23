package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.model.Users;
import com.masai.repository.UserRepository;
import com.masai.service.UserServiceInterface;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserServiceInterface serviceInterface;
	@Autowired
	private UserRepository usersRepositry;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
// user Register
@PostMapping("/users")
ResponseEntity<Users> registerUser(@Valid @RequestBody Users user){
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	user.setRole("user");
	return new ResponseEntity<Users>(serviceInterface.addUsers(user),HttpStatus.CREATED);
}
//user Login
@GetMapping("/logini")
public ResponseEntity<Users> logInUserHandler(Authentication auth){
	 Optional<Users> opt= usersRepositry.findByEmail(auth.getName());
	 
	 if(opt.isEmpty()) throw new RuntimeException("No user found") ;
	 Users user = opt.get();
	 return new ResponseEntity<Users>(user, HttpStatus.OK);
}
//get user By userId
@GetMapping("/users/{userId}")
public ResponseEntity<Users> getUser(@PathVariable Integer userId){

	 return new ResponseEntity<Users>(serviceInterface.getUser(userId), HttpStatus.OK);
}
//Add Book to user wishList
@PostMapping("/users/wishList/{userId}/{bookId}")
ResponseEntity<List<Book>> addBookToWishList(@PathVariable Integer userId,Integer bookId){

	return new ResponseEntity<List<Book>>(serviceInterface.addBookToWishList(userId,bookId),HttpStatus.CREATED);
}
//get Book from user wishList
@GetMapping("/users/wishList/{userId}")
ResponseEntity<List<Book>> getBookFromWishList(@PathVariable Integer userId){
	return new ResponseEntity<List<Book>>(serviceInterface.getBookFromWishList(userId),HttpStatus.CREATED);
}
//Add Book to user Reading Lists
@PostMapping("/users/ReadingList/{userId}/{bookId}")
ResponseEntity<List<Book>> addBookToReadingList(@PathVariable Integer userId,Integer bookId){

	return new ResponseEntity<List<Book>>(serviceInterface.addBookToReadingList(userId,bookId),HttpStatus.CREATED);
}
//get Book from user Reading Lists
@GetMapping("/users/ReadingList/{userId}")
ResponseEntity<List<Book>> getBookFromReadingList(@PathVariable Integer userId){
	return new ResponseEntity<List<Book>>(serviceInterface.getBookFromReadingList(userId),HttpStatus.CREATED);
}

//Get All Books
@GetMapping("/users")
public ResponseEntity<List<Users>> getAllUser(){

	 return new ResponseEntity<List<Users>>(serviceInterface.getAllUser(), HttpStatus.OK);
}

}
