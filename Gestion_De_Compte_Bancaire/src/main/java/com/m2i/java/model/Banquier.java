package com.m2i.java.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
