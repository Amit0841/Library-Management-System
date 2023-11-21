package com.masai.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discussions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int discussionsId;
	@ManyToOne
	private Users user;
	private String title;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Chat> chat;
}
