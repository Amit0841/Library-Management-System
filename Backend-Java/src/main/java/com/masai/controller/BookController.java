package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookServiceInterface;

@RestController
public class BookController {
	
@Autowired
private BookServiceInterface bookServiceInterface;
// add Book to DB
@PostMapping("books")
ResponseEntity<Book> addBooks( @RequestBody Book book){
	return new ResponseEntity<Book>(bookServiceInterface.addBooks(book),HttpStatus.CREATED);
}
//get All Book from DB
@GetMapping("books")
ResponseEntity<List<Book>> getBooks(){
	return new ResponseEntity<List<Book>>(bookServiceInterface.getBooks(),HttpStatus.OK);
}
//get Book from DB By Book Id
@GetMapping("books/{bookId}")
ResponseEntity<Book> getBooks(@PathVariable Integer bookId){
	return new ResponseEntity<Book>(bookServiceInterface.getBooks(bookId),HttpStatus.OK);
}
//get Book from DB By Book Id
@DeleteMapping("books/{bookId}")
ResponseEntity<Book> deleteBooks(@PathVariable Integer bookId){
	return new ResponseEntity<Book>(bookServiceInterface.deleteBooks(bookId),HttpStatus.OK);
}

}
