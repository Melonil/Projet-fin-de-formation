package com.m2i.java.service.implementation;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.m2i.java.DTO.BanquierDTO;
import com.m2i.java.DTO.BanquierDTOMapper;
import com.m2i.java.model.Agence;
import com.m2i.java.model.Banquier;
import com.m2i.java.model.UserDetails;
import com.m2i.java.repository.AgenceRepository;
import com.m2i.java.repository.BanquierRepository;
import com.m2i.java.repository.UserDetailsRepository;
import com.m2i.java.service.CRUDService;

@Service
public class BanquierService implements CRUDService<BanquierDTO>{
	
	private final BanquierRepository banquierRepository;
	private final AgenceRepository agenceRepository;
	private final UserDetailsRepository userDetailsRepository;
	private BanquierDTOMapper banquierDTOMapper;
	
	

	public BanquierService(BanquierRepository banquierRepository, AgenceRepository agenceRepository,
			UserDetailsRepository userDetailsRepository, BanquierDTOMapper banquierDTOMapper) {
		this.banquierRepository = banquierRepository;
		this.agenceRepository = agenceRepository;
		this.userDetailsRepository = userDetailsRepository;
		this.banquierDTOMapper = banquierDTOMapper;
	}

	@Override
	public Collection<BanquierDTO> list(int limit) {
		return banquierRepository.findAll(PageRequest.of(0, limit))
				.toList()
				.stream()
				.map(banquier -> banquierDTOMapper.map(banquier))
				.collect(Collectors.toList());
	}

	@Override
	public BanquierDTO create(BanquierDTO banquierDTO) {
		Agence agence = agenceRepository.findById(banquierDTO.idAgence()).orElseThrow(() -> new RuntimeException("Agence non trouvé"));
		UserDetails userDetails = userDetailsRepository.findById(banquierDTO.idUserDetails()).orElseThrow(() -> new RuntimeException("UserDetails non trouvé"));
		
		Banquier banquierToCreate = banquierDTOMapper.map(banquierDTO, agence, userDetails);
		
		System.out.println("Saving new Banquier : " + banquierDTO.numEmploye());
		System.out.println(banquierDTO.toString());
		Banquier savedBanquier = banquierRepository.save(banquierToCreate);
		
		return banquierDTOMapper.map(savedBanquier);
	}

	@Override
	public BanquierDTO update(BanquierDTO banquierDTO) {
		Banquier banquier = banquierRepository.findById(banquierDTO.id()).orElseThrow(() -> new RuntimeException("Banquier non trouvé"));	
		Agence agence = agenceRepository.findById(banquierDTO.idAgence()).orElseThrow(() -> new RuntimeException("Agence non trouvé"));
		UserDetails userDetails = userDetailsRepository.findById(banquierDTO.idUserDetails()).orElseThrow(() -> new RuntimeException("UserDetails non trouvé"));

		
		banquier.setLogin(banquierDTO.login());
		banquier.setPassword(banquierDTO.password());
		banquier.setRole(banquierDTO.role());
		banquier.setAgence(agence);
		banquier.setUserDetails(userDetails);
		
		System.out.println("Updating Banquier : " + banquierDTO.numEmploye());
		Banquier updatedBanquier = banquierRepository.save(banquier);
		
		return banquierDTOMapper.map(updatedBanquier);
	}

	@Override
	public BanquierDTO get(Long id) {
		System.out.println("Retriving  Banquier by ID : " + id);
		return banquierRepository.findById(id).map(banquier -> banquierDTOMapper.map(banquier)).get();
	}

	@Override
	public Boolean delete(Long id) {
		System.out.println("Deleting Banquier by ID : " + id);
		banquierRepository.deleteById(id);
		return true;
	}

}
