package com.m2i.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class UserDetails {
	
	@Id
	@Column(nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nom;
	
	@Column(nullable=false)
	private String prenom;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String numTel;

	public UserDetails(String nom, String prenom, String email, String numTel) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numTel = numTel;
	}

	public UserDetails() {
	}

}
