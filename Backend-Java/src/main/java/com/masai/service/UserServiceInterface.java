package com.masai.service;

import java.util.List;

import com.masai.model.Book;
import com.masai.model.Users;
import com.masai.model.WishList;

public interface UserServiceInterface {

	Users addUsers(Users user);

	Users getUser(Integer id);

	List<Users> getAllUser();

	Book addBookToWishList(Integer userId, Integer bookId, WishList wishList);

	List<Book> addBookToReadingList(Integer userId, Integer bookId);

	List<Book> getBookFromWishList(Integer userId);

	List<Book> getBookFromReadingList(Integer userId);

	Book deleteBookFromWishList(Integer userId, Integer bookId);

}
