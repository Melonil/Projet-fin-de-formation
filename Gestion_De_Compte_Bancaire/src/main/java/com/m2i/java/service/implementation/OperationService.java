package com.m2i.java.service.implementation;

import com.m2i.java.DTO.OperationDTO;
import com.m2i.java.DTO.OperationDTOMapper;
import com.m2i.java.model.Compte;
import com.m2i.java.model.Operation;
import com.m2i.java.repository.CompteRepository;
import com.m2i.java.repository.OperationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    private OperationRepository operationRepository;

    private CompteRepository compteRepository;

    private final OperationDTOMapper operationDTOMapper;

    public OperationService(OperationRepository operationRepository, CompteRepository compteRepository, OperationDTOMapper operationDTOMapper) {
        this.operationRepository = operationRepository;
        this.compteRepository = compteRepository;
        this.operationDTOMapper = operationDTOMapper;
    }

    public void saveOperation(Operation operation) {
        operationRepository.save(operation);
    }

    public List<OperationDTO> list(Long idCompte, int limit){
        Compte compte = compteRepository.findById(idCompte).orElseThrow(() -> new RuntimeException("Compte non trouvé"));
        return operationRepository.findAllByCompteOrderByDateOperationDesc(compte).stream().map(operation -> operationDTOMapper.map(operation)).toList();
    }
}
