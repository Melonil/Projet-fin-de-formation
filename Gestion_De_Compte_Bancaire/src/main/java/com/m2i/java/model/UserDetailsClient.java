package com.m2i.java.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class UserDetailsClient extends UserDetails {

	@Id
	@Column(nullable=false,updatable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String adressePostale;

	@Column(nullable=false)
	private String dateNaissance;

	@Column(nullable=false)
	private String nationalite;

	@Column(nullable=false)
	private String lieuNaissance;

	@Column(nullable=false)
	private String profession;


	@Column(nullable=false)
	private Double revenu;

	public UserDetailsClient(Long id,String adressePostale, String dateNaissance, String nationalite, String lieuNaissance,
			String profession, Double revenu, String nom, String prenom, String email, String numTel) {
		super(nom, prenom, email, numTel);
		this.id = id;
		this.adressePostale = adressePostale;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.lieuNaissance = lieuNaissance;
		this.profession = profession;
		this.revenu = revenu;
	}

	public UserDetailsClient() {
	}


	@Override
	public String toString() {
		return "UserDetailsClient [adressePostale=" + adressePostale
				+ ", dateNaissance=" + dateNaissance + ", nationalite=" + nationalite + ", lieuNaissance="
				+ lieuNaissance + ", profession=" + profession + ", revenu=" + revenu + "]";
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getAdressePostale() {
		return adressePostale;
	}

	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Double getRevenu() {
		return revenu;
	}

	public void setRevenu(Double revenu) {
		this.revenu = revenu;
	}
}