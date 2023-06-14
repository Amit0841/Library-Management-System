package com.masai.Dao;

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

	void addBook(Book bo) throws SomethingWentWrong;
	
}
