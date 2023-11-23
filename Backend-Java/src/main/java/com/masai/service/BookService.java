package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Book;
import com.masai.repository.BookRepository;
@Service
public class BookService implements BookServiceInterface{
	@Autowired
	private BookRepository bookRepository;
	
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

}
