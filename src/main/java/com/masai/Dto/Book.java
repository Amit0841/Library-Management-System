package com.masai.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private String bookId;
	private String bookTitle;
	private String author;
	private double rentPrice;
    private boolean availability;
    @ManyToOne
    private Librarian adminId;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookId, String bookTitle, String author, double rentPrice, boolean availability, Librarian adminId) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.rentPrice = rentPrice;
		this.availability = availability;
		this.adminId = adminId;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public Librarian getAdminId() {
		return adminId;
	}
	public void setAdminId(Librarian adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", rentPrice="
				+ rentPrice + ", availability=" + availability + ", adminId=" + adminId + "]";
	}
	
    
}
