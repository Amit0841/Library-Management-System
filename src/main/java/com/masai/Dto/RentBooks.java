package com.masai.Dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class RentBooks {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int rentId;
@OneToOne
private Book bi;
private LocalDate rentFrom;
private LocalDate rentTo;
@ManyToOne
private Student Sid;

public RentBooks(Book bi, LocalDate rentFrom, LocalDate rentTo, Student sid) {
	super();
	this.bi = bi;
	this.rentFrom = rentFrom;
	this.rentTo = rentTo;
	Sid = sid;
}

public RentBooks() {
	super();
	// TODO Auto-generated constructor stub
}

public int getRentId() {
	return rentId;
}
public void setRentId(int rentId) {
	this.rentId = rentId;
}

public LocalDate getRentFrom() {
	return rentFrom;
}
public void setRentFrom(LocalDate rentFrom) {
	this.rentFrom = rentFrom;
}
public LocalDate getRentTo() {
	return rentTo;
}
public void setRentTo(LocalDate rentTo) {
	this.rentTo = rentTo;
}


}
