package com.publictions.demo.entity;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
@Data
@Entity
@Table(name = "publictions"/*, uniqueConstraints =@UniqueConstraint(columnNames={"isbn"})*/)
public class Publications {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "type")
	private String typePubliction;
	
	@Column(name = "isbn")
	private String ISBN;
	
	@Column(name = "title")
	private String title;
	

	
	
	public Publications() {
	}

	public Publications(String type, String iSBN, String title) {
		this.typePubliction = type;
		ISBN = iSBN;
		this.title = title;
	}
	

/*	if we need to make Beidircation

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,
			   CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "publictions_id")
	private Publications publiction;*/







}
