package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bookId;
private String title;
private String author;
private String image;
private String genre;
private String description;
private double price;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JsonIgnore
List<ReviewsAndRatings> review;
}
