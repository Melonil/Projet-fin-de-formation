package com.m2i.java.service.implementation;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import com.m2i.java.ENUM.TypeOperation;
import com.m2i.java.model.Operation;
import com.m2i.java.repository.OperationRepository;
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
	
	public CompteService(CompteRepository compteRepo, AgenceRepository agenceRepository, ClientRepository clientRepository, CompteDTOMapper compteDTOMapper, OperationRepository operationRepository) {
		this.compteRepository = compteRepo;
		this.compteDTOMapper = compteDTOMapper;
		this.agenceRepository = agenceRepository;
		this.clientRepository = clientRepository;
	}

	@Override
	public Collection<CompteDTO> list(int limit) {
		System.out.println("Fetching all Comptes");
		return compteRepository.findAll(PageRequest.of(0,limit))
				.stream()
				.map(compte -> compteDTOMapper.map(compte)).collect(Collectors.toList());
	}

	@Override
	public CompteDTO create(CompteDTO compteDTO) {
		Agence agence = agenceRepository.findById(compteDTO.idAgence()).orElseThrow(() -> new RuntimeException("Agence non trouvé"));
	    Client client = clientRepository.findById(compteDTO.idClient()).orElseThrow(() -> new RuntimeException("Client non trouvé"));

	    Compte compteToCreate = compteDTOMapper.map(compteDTO, agence, client);
		compteToCreate.setDateCreation(LocalDateTime.now());
		System.out.println("Saving new Compte :"+compteDTO.numCompte());
		System.out.println(compteDTO);
		Compte savedCompte = compteRepository.save(compteToCreate);
		
		return compteDTOMapper.map(savedCompte);
	}

	@Override
	public CompteDTO update(CompteDTO compteDTO) {
		System.out.println("Updating Compte :"+compteDTO.numCompte());
		
		Compte compte = compteRepository.findById(compteDTO.id()).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
		compte.setDecouvertAutorise(compteDTO.decouvertAutorise());
		compte.setSolde(compteDTO.solde());
		
		Compte updatedCompte = compteRepository.save(compte);
		return compteDTOMapper.map(updatedCompte);
	}

	@Override
	public CompteDTO get(Long id) {
		System.out.println("Retriving  Compte by ID :"+id);
		Compte retrivedCompte = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte non trouvé"));

		return compteDTOMapper.map(retrivedCompte);
	}

	@Override
	public Boolean delete(Long id) {
		System.out.println("Deleting Compte by ID :"+id);
		compteRepository.deleteById(id);
		return true;
	}

	public CompteDTO retrait(Long id, float amount,OperationService operationService) {
		Compte compte = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
		if(compte.getSolde() - amount >= compte.getDecouvertAutorise()) {
			compte.setSolde(compte.getSolde() - amount);
			compteRepository.save(compte);
			operationService.saveOperation(new Operation(null,compte,amount, LocalDateTime.now(),TypeOperation.RETRAIT));
			return compteDTOMapper.map(compte);
		}else{
			throw new RuntimeException("Solde insuffisant");
		}
	}


	public CompteDTO depot(Long id, float amount,OperationService operationService) {
		Compte compte = compteRepository.findById(id).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
		compte.setSolde(compte.getSolde() + amount);
		compteRepository.save(compte);
		operationService.saveOperation(new Operation(null,compte,amount, LocalDateTime.now(),TypeOperation.DEPOT));
		return compteDTOMapper.map(compte);
	}


	public CompteDTO getCompteByIdClient(Long idClient){
		Client client = clientRepository.findById(idClient).orElseThrow(() -> new RuntimeException("Client non trouvé"));
		Compte compte = compteRepository.findFirstCompteByClientOrderByDateCreation(client);
		return compteDTOMapper.map(compte);
	}

}
