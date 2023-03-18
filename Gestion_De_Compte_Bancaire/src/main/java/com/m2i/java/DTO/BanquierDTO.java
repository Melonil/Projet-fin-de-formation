package com.m2i.java.DTO;

import com.m2i.java.ENUM.ROLE;

public record BanquierDTO(
		Long id,
		String numEmploye,
		String login,
		String password,
		ROLE role,
		Long idAgence,
		Long idUserDetails
		) {
	
}
