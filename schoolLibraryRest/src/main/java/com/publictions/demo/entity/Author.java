package com.publictions.demo.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
@Data
@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	//@NotBlank(message = "fiald is requered")
	private String firstName;
	
	@Column(name = "last_name")
	//@NotBlank(message = "fiald is requered")
	private String lastName;
	
	@Column(name ="email")
	//@NotBlank(message = "fiald is requered")
	private String email;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_Id")
	private List<Publications> publications;

	public Author() {}
	
	public Author(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	
	public void add(Publications thePublications) {
		if (publications==null ){
			publications = new ArrayList<>();
		}
		publications.add(thePublications);
	}

	
}
