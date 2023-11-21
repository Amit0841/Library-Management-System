package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
	@Id
	private int CId;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private Users user;
private String message;
}
