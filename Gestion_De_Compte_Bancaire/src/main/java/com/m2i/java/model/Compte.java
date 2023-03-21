package com.m2i.java.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.CascadeType;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compte {
	@Id
	@Column(nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,nullable=false,updatable=false)
	private String numCompte;
	
	private float decouvertAutorise;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn( name="idAgence" )
	private Agence agence;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn( name="idClient" )
	private Client client;

	private float solde;

	@Column(nullable=false,updatable=false)
	private LocalDateTime dateCreation;

	public Compte(Compte compte) {
		this.id = compte.id;
		this.numCompte = compte.numCompte;
		this.decouvertAutorise = compte.decouvertAutorise;
		this.agence = compte.getAgence();
		this.client = compte.getClient();
	}

    @Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [id=").append(id).append(", numCompte=").append(numCompte).append(", decouvertAutorise=")
				.append(decouvertAutorise).append(", solde=")
				.append(solde).append(", agence=").append(agence).append(", client=").append(client)
				.append("]");
		return builder.toString();
	}
	
}
