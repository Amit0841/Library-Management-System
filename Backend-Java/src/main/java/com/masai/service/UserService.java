package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Book;
import com.masai.model.Users;
import com.masai.repository.BookRepository;
import com.masai.repository.UserRepository;

@org.springframework.stereotype.Service
public class UserService implements UserServiceInterface{
	@Autowired
private UserRepository userRepository;
	@Autowired
private BookRepository bookRepository;
	@Override
	public Users addUsers(Users user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public Users getUser(Integer id) {
		Optional<Users> user=userRepository.findById(id);
		return user.get();
	}

	@Override
	public List<Users> getAllUser() {
		List<Users> user=userRepository.findAll();
		return user;
	}

	@Override
	public List<Book> addBookToWishList(Integer userId, Integer bookId) {
		Optional<Book> b=bookRepository.findById(bookId);
		Optional<Users> u=userRepository.findById(userId);
		Users user=u.get();
		Book book=b.get();
		user.getWishList().add(book);
		userRepository.save(user);
		return user.getWishList();
	}
	@Override
	public List<Book> getBookFromWishList(Integer userId) {
		Optional<Users> u=userRepository.findById(userId);
		Users user=u.get();
		return user.getWishList();
	}
	@Override
	public List<Book> addBookToReadingList(Integer userId, Integer bookId) {
		Optional<Book> b=bookRepository.findById(bookId);
		Optional<Users> u=userRepository.findById(userId);
		Users user=u.get();
		Book book=b.get();
		user.getReadingLists().add(book);
		userRepository.save(user);
		return user.getReadingLists();
	}
	@Override
	public List<Book> getBookFromReadingList(Integer userId) {
		Optional<Users> u=userRepository.findById(userId);
		Users user=u.get();
		return user.getReadingLists();
	}
	

	

}
