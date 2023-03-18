package com.m2i.java.DTO;

import java.util.List;

import com.m2i.java.model.Operation;
import org.springframework.stereotype.Component;

import com.m2i.java.model.Agence;
import com.m2i.java.model.Client;
import com.m2i.java.model.Compte;

//crée un bean injectable
@Component
public class CompteDTOMapper {

	public CompteDTO map(Compte compte) {
		return new CompteDTO(compte.getId(),compte.getNumCompte(),compte.getDecouvertAutorise(),compte.getAgence().getId(),compte.getClient().getId(), compte.getSolde() );
	}
	
	public Compte map(CompteDTO compteDTO,Agence agence,Client client) {
		return new Compte(compteDTO.id(),compteDTO.numCompte(),compteDTO.decouvertAutorise(),agence,client,compteDTO.solde());
	}

}
