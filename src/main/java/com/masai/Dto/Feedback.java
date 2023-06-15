package com.masai.Dto;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Feedback {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int FeedId;
private String Massage;
private double rating;
@ManyToOne
private Book bId;
public Feedback() {
	super();
	// TODO Auto-generated constructor stub
}
public Feedback(String massage, double rating, Book bId) {
	super();
	Massage = massage;
	this.rating = rating;
	this.bId = bId;
}
public int getFeedId() {
	return FeedId;
}
public void setFeedId(int feedId) {
	FeedId = feedId;
}
public String getMassage() {
	return Massage;
}
public void setMassage(String massage) {
	Massage = massage;
}
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public Book getbId() {
	return bId;
}
public void setbId(Book bId) {
	this.bId = bId;
}
@Override
public String toString() {
	return "Feedback [FeedId=" + FeedId + ", Massage=" + Massage + ", rating=" + rating + ", bId=" + bId + "]";
}

}
