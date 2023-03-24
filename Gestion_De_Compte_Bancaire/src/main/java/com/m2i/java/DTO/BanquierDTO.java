package com.m2i.java.DTO;

public record BanquierDTO(
		Long id,
		String numEmploye,
		String nom,
		String prenom,
		String email,
		String numTel,
		Long idAgence
		) {
	
}
