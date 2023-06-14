package com.masai.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private String bookId;
	private String bookTitle;
	private String author;
	private double rentPrice;
    private boolean availability;
    private int adminId;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookId, String bookOTitle, String author, double rentPrice, boolean availability, int adminId) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookOTitle;
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
	public String getBookOTitle() {
		return bookTitle;
	}
	public void setBookOTitle(String bookOTitle) {
		this.bookTitle = bookOTitle;
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
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookOTitle=" + bookTitle + ", author=" + author + ", rentPrice="
				+ rentPrice + ", availability=" + availability + ", adminId=" + adminId + "]";
	}
	
    
}
