package com.masai.Ui;

import java.util.Scanner;

import com.masai.Dao.DaoImpel;
import com.masai.Dao.DaoInterface;
import com.masai.Dto.Book;
import com.masai.Dto.Librarian;
import com.masai.Dto.Student;
import com.masai.Exception.NoRecordFound;
import com.masai.Exception.SomethingWentWrong;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=0;
		do {
			System.out.println("1. Librarian");
			System.out.println("2. Student");
			System.out.println("0. Exit");
			c=sc.nextInt();
			switch(c){
			case 1 -> librarian(sc);
			case 2 -> student(sc);
			}
		}while(c!=0);
		sc.close();

	}

	private static void student(Scanner sc) {
		int c=0;
		do {
			System.out.println("1. sign In student");
			System.out.println("2. log In student");
			System.out.println("0. Previous Menu");
			c=sc.nextInt();        
			switch(c){
			case 1 -> signInStudent(sc);
			case 2 -> logInStudent(sc);
			}
		}while(c!=0);
	}
	
	private static void logInStudent(Scanner sc) {
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		DaoInterface d=new DaoImpel();
		try {
			int id=d.loginStu(email,pass);
			System.out.println("login success");
			
		} catch (SomethingWentWrong | NoRecordFound k) {
			// TODO Auto-generated catch block
			System.out.println(k);
		}
	}

	private static void signInStudent(Scanner sc) {
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		Student s=new Student(name, email, pass);
		DaoInterface d=new DaoImpel();
		try {
			d.addStu(s);
			System.out.println("Added done");
		} catch (SomethingWentWrong k) {
			// TODO Auto-generated catch block
			k.printStackTrace();
		}
	}

	private static void logInLibrarian(Scanner sc) {
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		DaoInterface d=new DaoImpel();
		try {
			int id=d.loginLibrarian(email,pass);
			System.out.println("login success");
			afterLoginLibrarian(id,sc);
		} catch (SomethingWentWrong | NoRecordFound k) {
			// TODO Auto-generated catch block
			System.out.println(k);
		}
	}

	private static void afterLoginLibrarian(int id, Scanner sc) {
		int c=0;
		do {
		
		System.out.println("1. Add Book");
		System.out.println("2. Update Book");
		System.out.println("3. Remove Book");
		System.out.println("4. View Book");
		System.out.println("5. View Book Feetback");
		System.out.println("0. LogOut");
		c=sc.nextInt();
		switch(c) {
		case 1 -> addBook(id,sc);
		
		}
		}while(c!=0);
		System.out.println("LogOut Librarian");

	}

	private static void addBook(int id, Scanner sc) {
		System.out.println("Enter Book Id");
		String Bid=sc.next();
		System.out.println("Enter Book Title");
		String bookOTitle=sc.next();
		System.out.println("Enter Book Author");
		String author=sc.next();
		System.out.println("Enter Book rentPrice");
		double price=sc.nextDouble();
		
		Book bo=new Book(Bid,bookOTitle,author, price, false, id);
		DaoInterface d=new DaoImpel();
		try {
			d.addBook(bo);
			
		} catch (SomethingWentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void signInLibrarian(Scanner sc) {
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		
		Librarian l=new Librarian(name, email, pass);
		DaoInterface d=new DaoImpel();
		try {
			d.add(l);
			System.out.println("Added done");
		} catch (SomethingWentWrong k) {
			// TODO Auto-generated catch block
			k.printStackTrace();
		}
	}

	private static void librarian(Scanner sc) {
		int c=0;
		do {
			System.out.println("1. sign In librarian");
			System.out.println("2. log In librarian");
			System.out.println("0. Previous Menu");
			c=sc.nextInt();        
			switch(c){
			case 1 -> signInLibrarian(sc);
			case 2 -> logInLibrarian(sc);
			}
		}while(c!=0);
	}

}
