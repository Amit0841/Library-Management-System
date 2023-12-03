package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private int wishListId;
	private String mes;
    @ManyToOne
	private Book book;
    @ManyToOne
    private Users user;
}
