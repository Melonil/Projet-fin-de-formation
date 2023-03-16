package com.m2i.java.DTO;

import org.springframework.stereotype.Component;

import com.m2i.java.model.Agence;
import com.m2i.java.model.Banquier;

@Component
public class BanquierDTOMapper {

	public BanquierDTO map(Banquier banquier) {
		return new BanquierDTO(banquier.getNom(), banquier.getPrenom(), banquier.getDateNaissance(),
				banquier.getId(), banquier.getNumEmploye(),
				banquier.getAgence().getId());
	}
	
	public Banquier map(BanquierDTO banquierDTO, Agence agence) {
		return new Banquier(banquierDTO.nom(), banquierDTO.prenom(), banquierDTO.dateNaissance(),
				banquierDTO.id(), banquierDTO.numEmploye(), agence);
	}
	
}
