package com.m2i.java.service.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.m2i.java.DTO.CompteDTO;
import com.m2i.java.DTO.CompteDTOMapper;
import com.m2i.java.model.Agence;
import com.m2i.java.model.Client;
import com.m2i.java.model.Compte;
import com.m2i.java.repository.AgenceRepository;
import com.m2i.java.repository.ClientRepository;
import com.m2i.java.repository.CompteRepository;
import com.m2i.java.service.CRUDService;


@Service
public class CompteService implements CRUDService<CompteDTO> {
	private final CompteRepository compteRepository;
	private AgenceRepository agenceRepository;
	private ClientRepository clientRepository;
	private final CompteDTOMapper compteDTOMapper;
	
	public CompteService(CompteRepository compteRepo,AgenceRepository agenceRepository,ClientRepository clientRepository, CompteDTOMapper compteDTOMapper) {
		this.compteRepository = compteRepo;
		this.compteDTOMapper = compteDTOMapper;
		this.agenceRepository = agenceRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public Collection<CompteDTO> list(int limit) {
		System.out.println("Fetching all Comptes");
		return compteRepository.findAll(PageRequest.of(0,limit))
				.toList()
				.stream()
				.map(compte -> compteDTOMapper.map(compte)).collect(Collectors.toList());
	}

	@Override
	public CompteDTO create(CompteDTO compteDTO) {
		Agence agence = agenceRepository.findById(compteDTO.idAgence()).orElseThrow(() -> new RuntimeException("Agence non trouvé"));
	    Client client = clientRepository.findById(compteDTO.idClient()).orElseThrow(() -> new RuntimeException("Client non trouvé"));

	    Compte compteToCreate = compteDTOMapper.map(compteDTO, agence, client);
		
		System.out.println("Saving new Compte :"+compteDTO.numCompte());
		System.out.println(compteDTO.toString());
		Compte savedCompte = compteRepository.save(compteToCreate);
		
		return compteDTOMapper.map(savedCompte);
	}

	@Override
	public CompteDTO update(CompteDTO compteDTO) {
		System.out.println("Updating Compte :"+compteDTO.numCompte());
		
		Compte compte = compteRepository.findById(compteDTO.id()).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
		compte.setDecouvertAutorise(compteDTO.decouvertAutorise());
		
		Compte updatedCompte = compteRepository.save(compte);
		return compteDTOMapper.map(updatedCompte);
	}

	@Override
	public CompteDTO get(Long id) {
		System.out.println("Retriving  Compte by ID :"+id);
		return compteRepository.findById(id).map(compte -> compteDTOMapper.map(compte)).get();
	}

	@Override
	public Boolean delete(Long id) {
		System.out.println("Deleting Compte by ID :"+id);
		compteRepository.deleteById(id);
		return true;
	}


}
