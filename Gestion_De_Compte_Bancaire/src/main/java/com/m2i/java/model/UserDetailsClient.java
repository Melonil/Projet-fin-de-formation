package com.m2i.java.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class UserDetailsClient extends UserDetails {
	@Column(nullable=false,updatable=false)
	private Long idUserDetailsClient;

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

	@Override
	public String toString() {
		return "UserDetailsClient [idUserDetailsClient=" + idUserDetailsClient + ", adressePostale=" + adressePostale
				+ ", dateNaissance=" + dateNaissance + ", nationalite=" + nationalite + ", lieuNaissance="
				+ lieuNaissance + ", profession=" + profession + ", revenu=" + revenu + "]";
	}
}