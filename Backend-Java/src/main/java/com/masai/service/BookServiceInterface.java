package com.masai.service;

import java.util.List;

import com.masai.model.Book;
import com.masai.model.ReviewsAndRatings;

public interface BookServiceInterface {

	Book addBooks(Book book);

	List<Book> getBooks();

	Book getBooks(Integer bookId);

	Book deleteBooks(Integer bookId);

	Book reviewBooks(Integer bookId, ReviewsAndRatings review, Integer userId);

	List<ReviewsAndRatings> getReviewBooks(Integer bookId);

	List<Book> searchByAuthor(String name);

}
