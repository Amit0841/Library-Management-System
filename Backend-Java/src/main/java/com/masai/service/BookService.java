package com.masai.service;

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

}
