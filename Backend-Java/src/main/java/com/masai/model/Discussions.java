package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Discussions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int discussionsId;
	@ManyToOne
	private Users user;
	private String title;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Chat> chat;
}
