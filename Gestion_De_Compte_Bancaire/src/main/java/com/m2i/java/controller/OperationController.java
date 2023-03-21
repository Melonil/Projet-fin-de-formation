package com.m2i.java.controller;

import com.m2i.java.DTO.OperationDTO;
import com.m2i.java.model.Operation;
import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/operation")
public class OperationController {

    private final OperationService operationService;


    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }
    
    @GetMapping("/list/{id}")
    public ResponseEntity<Collection<OperationDTO>> getOperations(@PathVariable("id") Long idCompte){
        System.out.println(operationService.list(idCompte,30));
        return ResponseEntity.ok(
            operationService.list(idCompte,30)
        );
    }
}
