package com.masai.service;

import java.util.List;

import com.masai.model.Book;

public interface BookServiceInterface {

	Book addBooks(Book book);

	List<Book> getBooks();

	Book getBooks(Integer bookId);

	Book deleteBooks(Integer bookId);

}
