package com.m2i.java.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Agence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false,updatable=false)
	private Long id;
	
	@Column(unique = true,nullable=false,updatable=false)
	private String numAgence;
	
	@Column(unique = true,nullable=false)
	private String adresseAgence;
	


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agence [id=");
		builder.append(id);
		builder.append(", numAgence=");
		builder.append(numAgence);
		builder.append(", adresseAgence=");
		builder.append(adresseAgence);
		builder.append("]");
		return builder.toString();
	}
	
}
