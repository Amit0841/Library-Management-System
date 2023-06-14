package com.masai.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int studentId;
private String name;
@Column(unique = true)
private String email;
private String pass;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String name, String email, String pass) {
	super();
	this.name = name;
	this.email = email;
	this.pass = pass;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
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
	return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", pass=" + pass + "]";
}

}
