package com.m2i.java.DTO;

import org.springframework.stereotype.Component;

import com.m2i.java.model.Agence;
import com.m2i.java.model.Banquier;
import com.m2i.java.model.UserDetails;

@Component
public class BanquierDTOMapper {

	public BanquierDTO map(Banquier banquier) {
		return new BanquierDTO(banquier.getId(), banquier.getNumEmploye(), banquier.getUserDetails().getNom(),
				banquier.getUserDetails().getPrenom(), banquier.getUserDetails().getEmail(),
				banquier.getUserDetails().getNumTel(), banquier.getAgence().getId());
	}
	
	public UserDetails map(BanquierDTO banquierDTO, Agence agence) {
		return new UserDetails(banquierDTO.nom(), banquierDTO.prenom(),
				banquierDTO.email(), banquierDTO.numTel());
	}
	
}
