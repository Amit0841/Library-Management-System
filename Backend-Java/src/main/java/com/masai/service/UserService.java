package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.masai.model.Book;
import com.masai.model.Users;
import com.masai.model.WishList;
import com.masai.repository.BookRepository;
import com.masai.repository.UserRepository;
import com.masai.repository.WishListRepository;

@org.springframework.stereotype.Service
public class UserService implements UserServiceInterface{
	@Autowired
private UserRepository userRepository;
	@Autowired
private BookRepository bookRepository;
	@Autowired
	private WishListRepository wishListRepository;
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
	public Book addBookToWishList(Integer userId, Integer bookId,WishList wish){
		boolean p=true;
		List<WishList> wish1=wishListRepository.findAll();
		for(WishList w :wish1) {
		if(w.getUser().getUserId()==userId && w.getBook().getBookId() == bookId) {
			p=false;
			throw new RuntimeException( "the book already added");
		}
		}
		
		if(p) {
			Optional<Book> bok=bookRepository.findById(bookId);
		Optional<Users> u=userRepository.findById(userId);
		Users user=u.get();
		Book book=bok.get();
		wish.setBook(book);
		wish.setUser(user);
		wishListRepository.save(wish);
		return book;
		}else {
			return null;
		}
		

		
	}
	@Override
	public List<Book> getBookFromWishList(Integer userId) {
		Optional<Users> u=userRepository.findById(userId);
		Users user=u.get();
		
		List<WishList> wish=wishListRepository.findAll();

		List<Book> wish2=new ArrayList<>();
		for(WishList w :wish) {
			if(w.getUser().getUserId()==userId) {
				wish2.add(w.getBook());
			}
		}
		
		return wish2;
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

	@Override
	public Book deleteBookFromWishList(Integer userId, Integer bookId) {
		List<WishList> wish=wishListRepository.findAll();
		Book wis=null;
		for(WishList w :wish) {
			if(w.getUser().getUserId()==userId && w.getBook().getBookId() == bookId) {
				wis=w.getBook();
				wishListRepository.delete(w);
				break;
			}
		}
		return wis;
	}
	

	

}
