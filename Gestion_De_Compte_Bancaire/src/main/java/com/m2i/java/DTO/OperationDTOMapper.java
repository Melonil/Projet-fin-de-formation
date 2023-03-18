package com.m2i.java.DTO;

import com.m2i.java.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationDTOMapper {
    public OperationDTO map(Operation operation){
        return new OperationDTO(
                operation.getCompte().getId(),
                operation.getTypeOperation(),
                operation.getMontant(),
                operation.getDateOperation()
        );
    }
}
