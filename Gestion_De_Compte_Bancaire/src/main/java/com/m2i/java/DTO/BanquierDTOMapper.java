package com.m2i.java.DTO;

import org.springframework.stereotype.Component;

import com.m2i.java.model.Agence;
import com.m2i.java.model.Banquier;
import com.m2i.java.model.UserDetails;

@Component
public class BanquierDTOMapper {

	public BanquierDTO map(Banquier banquier) {
		return new BanquierDTO(banquier.getId(), banquier.getNumEmploye(), banquier.getLogin(),
				banquier.getPassword(), banquier.getRole(),
				banquier.getAgence().getId(), banquier.getUserDetails().getId());
	}
	
	public Banquier map(BanquierDTO banquierDTO, Agence agence, UserDetails userDetails) {
		return new Banquier(banquierDTO.id(), banquierDTO.numEmploye(), banquierDTO.login(),
				banquierDTO.password(), banquierDTO.role(), agence, userDetails);
	}
	
}
