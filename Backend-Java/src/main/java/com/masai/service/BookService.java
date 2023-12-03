package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Book;
import com.masai.model.ReviewsAndRatings;
import com.masai.model.Users;
import com.masai.repository.BookRepository;
import com.masai.repository.UserRepository;
@Service
public class BookService implements BookServiceInterface{
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	@Override
	public Book addBooks(Book book) {
		bookRepository.save(book);
		return book;
	}
	
	@Override
	public List<Book> getBooks() {
		List<Book> books=bookRepository.findAll();
		return books;
	}

	@Override
	public Book getBooks(Integer bookId) {
		Optional<Book> books=bookRepository.findById(bookId);
		return books.get();
	}

	@Override
	public Book deleteBooks(Integer bookId) {
		Optional<Book> books=bookRepository.findById(bookId);
		bookRepository.delete(books.get());
		return books.get();
	}

	@Override
	public Book reviewBooks(Integer bookId, ReviewsAndRatings review, Integer userId) {
		Optional<Book> books=bookRepository.findById(bookId);
		Book book=books.get();
		Optional<Users> users=userRepository.findById(userId);
		review.setUser(users.get());
		book.getReview().add(review);
		bookRepository.save(book);
		return book;
	}

	@Override
	public List<ReviewsAndRatings> getReviewBooks(Integer bookId) {
		Optional<Book> books=bookRepository.findById(bookId);
		Book book=books.get();
		
		return book.getReview();
	}

	@Override
	public List<Book> searchByAuthor(String name) {
		
		List<Book> book=bookRepository.findAll();
//		List<Book> book1=new ArrayList<>();
		
//		for(Book b:book) {
//
//			if(b.getAuthor().equalsIgnoreCase(name)) {
//				book1.add(b);
//			}
//		}
//		System.out.println(book1);
		
		return book;
	}

	

}
