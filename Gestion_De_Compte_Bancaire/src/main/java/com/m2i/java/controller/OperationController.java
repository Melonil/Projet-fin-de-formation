package com.m2i.java.controller;

import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.Map;

public class OperationController {

    private final OperationService operationService;


    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }
    
    @GetMapping("/list")
    public ResponseEntity<Response> getOperations(@PathVariable("id") Long idCompte){

        return ResponseEntity.ok(
            Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .message("Operations retrieved")
                .data(Map.of("operations",operationService.list(idCompte,30)))
                .build()
        );
    }
}
