package com.masai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	private String name;
	@Column(unique = true)
	@NotNull
	@Email(message = "Email should be in proper format")
	private String email;
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	@NotNull
	private String mobileNumber;
	private String role;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Book> readingLists;
	
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private List<Book> wishList;
}
