package com.m2i.java.DTO;

import com.m2i.java.model.Agence;
import com.m2i.java.model.Client;
import com.m2i.java.model.Operation;

import java.util.List;


public record CompteDTO(
		Long id,
		String numCompte,
		float decouvertAutorise,
		Long idAgence,
		Long idClient,
		float solde
) {

}
