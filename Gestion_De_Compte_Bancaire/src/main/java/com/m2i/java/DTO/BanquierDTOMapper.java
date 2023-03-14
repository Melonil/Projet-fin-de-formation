package com.m2i.java.DTO;

import com.m2i.java.model.Agence;
import com.m2i.java.model.Banquier;

public class BanquierDTOMapper {

	public BanquierDTO map(Banquier banquier) {
		return new BanquierDTO(banquier.getId(), banquier.getNumEmploye(), banquier.getAgence().getId());
	}
	
	public Banquier map(BanquierDTO banquierDTO, Agence agence) {
		return new Banquier(banquierDTO.id(), banquierDTO.numEmploye(), agence);
	}
	
}
