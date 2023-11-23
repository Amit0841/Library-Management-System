package com.masai.service;

import java.util.List;

import com.masai.model.Book;
import com.masai.model.Users;

public interface UserServiceInterface {

	Users addUsers(Users user);

	Users getUser(Integer id);

	List<Users> getAllUser();

	List<Book> addBookToWishList(Integer userId, Integer bookId);

	List<Book> addBookToReadingList(Integer userId, Integer bookId);

	List<Book> getBookFromWishList(Integer userId);

	List<Book> getBookFromReadingList(Integer userId);

}
