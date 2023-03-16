package com.m2i.java.DTO;

import java.sql.Date;

public record BanquierDTO(
		String nom,
		String prenom,
		Date dateNaissance,
		Long id,
		String numEmploye,
		Long idAgence) {
	
}
