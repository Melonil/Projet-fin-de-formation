package com.m2i.java.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Data
public class Banquier extends Personne{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private Long id;
	
	@Column(unique = true,nullable=false,updatable=false)
	private String numEmploye;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="idAgence")
	private Agence agence;
	
	public Banquier() {
		super();
	}
	
	@Builder
	public Banquier(String nom, String prenom, Date dateNaissance, Long id, String numEmploye, Agence agence) {
		super(nom, prenom, dateNaissance);
		this.id = id;
		this.numEmploye = numEmploye;
		this.agence = agence;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banquier [id=");
		builder.append(id);
		builder.append(", numEmploye=");
		builder.append(numEmploye);
		builder.append(", agence=");
		builder.append(agence);
		builder.append("]");
		return builder.toString();
	}


}
