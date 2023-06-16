package com.masai.Ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.masai.Dao.DaoImpel;
import com.masai.Dao.DaoInterface;
import com.masai.Dto.Book;
import com.masai.Dto.Feedback;
import com.masai.Dto.Librarian;
import com.masai.Dto.RentBooks;
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
	
	
//        * * * * * Student * * * * *
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
			System.out.println("*Added done*");
		} catch (SomethingWentWrong k) {
			// TODO Auto-generated catch block
			k.printStackTrace();
		}
	}
	
	
	private static void logInStudent(Scanner sc) {
		System.out.println("Enter Email");
		String email=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		DaoInterface d=new DaoImpel();
		try {
			int id=d.loginStu(email,pass);
			System.out.println("* login success *");
			afterLoginStudent(id,sc);
		} catch (SomethingWentWrong | NoRecordFound k) {
			// TODO Auto-generated catch block
			System.out.println(k);
		}
	}
	
	
    private static void afterLoginStudent(int id, Scanner sc) {
	int c=0;
	do {
		System.out.println("1. View Available books");
		System.out.println("2. Apply Filter");
		System.out.println("3. Rent a book");
		System.out.println("4. Provide feedback and ratings");
		System.out.println("5. Return Book");
		System.out.println("0. Log out");
		c=sc.nextInt();
		switch(c) {
		case 1 -> viewAvailable();
		case 2 -> applyFilter(sc);
		case 3 -> rBook(sc ,id);
		case 4 -> giveFeetback(sc);
		case 5 -> returnBook(sc,id);
		}
	}while(c!=0);
	System.out.println("*Student Log out*");	
	}
static void rb(int id) {
	 DaoInterface d=new DaoImpel();
	 try {
		List <RentBooks>b=d.getBook(id);
		b.forEach(a->System.out.println("Book Id="+a.getBi()));
	} catch (SomethingWentWrong | NoRecordFound e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void returnBook(Scanner sc, int id) {
	rb(id);
	System.out.println("Enter Book Id");
	String bId=sc.next();
	 DaoInterface d=new DaoImpel();
		try {
			d.returnBook(bId);
			 
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
	}


private static void giveFeetback(Scanner sc) {
	viewAvailable();
	System.out.println("Enter Book Id");
	String bId=sc.next();
	System.out.println("Enter your Massage");
	String massage=sc.next();
	System.out.println("Enter Book Rating");
	double rating=sc.nextDouble();

	 DaoInterface d=new DaoImpel();
		try {
			 d.giveF(bId, massage, rating);
			 
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
	}


private static void rBook(Scanner sc, int id) {
	viewAvailable();
	rentBook(sc,id);
	}


private static void rentBook(Scanner sc, int id) {
	
	System.out.println("");
	System.out.println("Enter Book Id");
	String BookId=sc.next();
	System.out.println("Enter Return Date");
	LocalDate date=LocalDate.parse(sc.next());
	LocalDate da=LocalDate.now();
	
	 DaoInterface d=new DaoImpel();
		try {
			 d.rentBook(BookId, da, date, id);
			
			
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
	}


private static void applyFilter(Scanner sc) {
	int c=0;
	do {
		System.out.println("1. Find book by Title");
		System.out.println("2. Find book by Author");
		System.out.println("3. Find book Asc by Title");
		System.out.println("4. Find book Desc by Title");
		System.out.println("0. Previous Menu");
		c=sc.nextInt();
		switch(c) {
		case 1 -> findByTitle(sc);
		case 2 -> findByAuthor(sc);
		case 3 -> asc();
		case 4 -> desc();
		}
	}while(c!=0);

	}


private static void desc() {
	 DaoInterface d=new DaoImpel();
		try {
			List<Book>b= d.viewBookDesc();
			b.forEach(a->System.out.println("Book Id="+a.getBookId()+", Author="+a.getAuthor()+", Book Title="+a.getBookTitle()+", Rent Price="+a.getRentPrice()));
			
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
}


private static void asc() {
	 DaoInterface d=new DaoImpel();
		try {
			List<Book>b= d.viewBookAsc();
			b.forEach(a->System.out.println("Book Id="+a.getBookId()+", Author="+a.getAuthor()+", Book Title="+a.getBookTitle()+", Rent Price="+a.getRentPrice()));
			
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
}


private static void findByAuthor(Scanner sc) {
	System.out.println("Enter Author Name");
	String name=sc.next();
	 DaoInterface d=new DaoImpel();
		try {
			List<Book>b= d.viewBookByAuthorName(name);
			b.forEach(a->System.out.println("Book Id="+a.getBookId()+", Author="+a.getAuthor()+", Book Title="+a.getBookTitle()+", Rent Price="+a.getRentPrice()));
			
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
}


private static void findByTitle(Scanner sc) {
	System.out.println("Enter book Title");
	String name=sc.next();
	 DaoInterface d=new DaoImpel();
		try {
			List<Book>b= d.viewBookByName(name);
			b.forEach(a->System.out.println("Book Id="+a.getBookId()+", Author="+a.getAuthor()+", Book Title="+a.getBookTitle()+", Rent Price="+a.getRentPrice()));
			
		} catch (SomethingWentWrong | NoRecordFound e) {
			System.out.println(e);
		}
}


private static void viewAvailable() {
	  DaoInterface d=new DaoImpel();
		try {
			List<Book>b= d.viewAvailableBook();
			b.forEach(a->System.out.println("Book Id="+a.getBookId()+", Author="+a.getAuthor()+", Book Title="+a.getBookTitle()+", Rent Price="+a.getRentPrice()));
	
		} catch (SomethingWentWrong | NoRecordFound e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}


//        * * * * * Librarian * * * * *
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
			System.out.println("*Added done*");
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
			System.out.println("* login success *");
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
		System.out.println("2. Update Book RentPrice");
		System.out.println("3. Remove Book");
		System.out.println("4. View Book");
		System.out.println("5. View Book Feedback");
		System.out.println("0. LogOut");
		c=sc.nextInt();
		switch(c) {
		case 1 -> addBook(id,sc);
		case 2 -> updateBook(sc);
		case 3 -> removeBook(sc);
		case 4 -> viewBook();
	    case 5 -> viewFeetback();
		}
		}while(c!=0);
		System.out.println("*LogOut Librarian*");
	}

	private static void viewFeetback() {
		
		DaoInterface d=new DaoImpel();
		try {
			List <Feedback> list=d.viewBookq();
			list.forEach(a->System.out.println(a));
		} catch (SomethingWentWrong | NoRecordFound e) {
			e.printStackTrace();
		}
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
		
	
		DaoInterface d=new DaoImpel();
		try {
			d.addBook(Bid,bookOTitle,author, price, id);
		} catch (SomethingWentWrong e) {
			e.printStackTrace();
		}
	}
	
	private static void updateBook(Scanner sc) {
		System.out.println("Enter Book Id");
		String Bid=sc.next();
		System.out.println("Enter Book rentPrice");
		double price=sc.nextDouble();
		
		DaoInterface d=new DaoImpel();
		try {
			d.upateRent(price,Bid);
			System.out.println("* Update Successfully *");
		} catch (SomethingWentWrong | NoRecordFound e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	private static void removeBook(Scanner sc) {
		System.out.println("Enter Book Id");
		String Bid=sc.next();
		DaoInterface d=new DaoImpel();
		try {
			d.removeBook(Bid);
			System.out.println("* Remove Successfully *");
		} catch (SomethingWentWrong | NoRecordFound e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

      private static void viewBook() {
    	  DaoInterface d=new DaoImpel();
  		try {
  			List<Book>b= d.viewBook();
  			b.forEach(a->System.out.println(a));
  		} catch (SomethingWentWrong | NoRecordFound e) {
  			// TODO Auto-generated catch block
  			System.out.println(e);
  		}
	}
}
