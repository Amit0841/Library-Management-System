package com.masai.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LibrarianId;
	private String name;
	private String email;
	private String pass;
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Librarian(String name, String email, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	public int getLibrarianId() {
		return LibrarianId;
	}
	public void setLibrarianId(int librarianId) {
		LibrarianId = librarianId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Librarian [LibrarianId=" + LibrarianId + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
	}
	
}
