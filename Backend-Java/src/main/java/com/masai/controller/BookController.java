package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookServiceInterface;

@RestController
public class BookController {
	
@Autowired
private BookServiceInterface bookServiceInterface;

@PostMapping("books")
ResponseEntity<Book> addBooks( @RequestBody Book book){
	
	return new ResponseEntity<Book>(bookServiceInterface.addBooks(book),HttpStatus.CREATED);
}
}
