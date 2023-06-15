package com.masai.Dao;

import java.time.LocalDate;
import java.util.List;

import com.masai.Dto.Book;
import com.masai.Dto.Librarian;

import com.masai.Dto.Student;
import com.masai.Exception.NoRecordFound;
import com.masai.Exception.SomethingWentWrong;

public interface DaoInterface {

	void add(Librarian l) throws SomethingWentWrong;

	void addStu(Student s) throws SomethingWentWrong;

	int loginStu(String email, String pass) throws SomethingWentWrong, NoRecordFound;

	int loginLibrarian(String email, String pass) throws SomethingWentWrong, NoRecordFound;

	void addBook(String bid, String bookOTitle, String author, double price, int id) throws SomethingWentWrong;

	void upateRent(double price, String bid) throws SomethingWentWrong, NoRecordFound;

	void removeBook(String bid) throws SomethingWentWrong, NoRecordFound;

	List<Book> viewBook() throws SomethingWentWrong, NoRecordFound;

	List<Book> viewAvailableBook() throws SomethingWentWrong, NoRecordFound;

	List<Book> viewBookByName(String name) throws SomethingWentWrong, NoRecordFound;

	List<Book> viewBookByAuthorName(String name) throws SomethingWentWrong, NoRecordFound;

	List<Book> viewBookDesc() throws SomethingWentWrong, NoRecordFound;

	List<Book> viewBookAsc() throws SomethingWentWrong, NoRecordFound;

	void rentBook(String bookId, LocalDate da, LocalDate date, int id) throws SomethingWentWrong, NoRecordFound;

	void viewBookq() throws SomethingWentWrong, NoRecordFound;

	
	
}
