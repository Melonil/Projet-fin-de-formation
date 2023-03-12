package com.m2i.java.model;

import java.sql.Date;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {
	private String nom;
	private String prenom;
	private Date dateNaissance;
}
