package com.m2i.java.DTO;

import com.m2i.java.ENUM.TypeOperation;
import com.m2i.java.model.Compte;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public record OperationDTO (
    Long idCompte,
    TypeOperation typeOperation,
    float montant,
    LocalDateTime dateOperation
)
{}
