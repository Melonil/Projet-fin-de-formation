package com.m2i.java.service.implementation;

import com.m2i.java.model.Operation;
import com.m2i.java.repository.OperationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public void saveOperation(Operation operation) {
        operationRepository.save(operation);
    }

    public List<Operation> list(Long idCompte,int limit){
        return operationRepository.findAllByCompteId(idCompte,PageRequest.of(0, limit));
    }
}
