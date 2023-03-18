package com.m2i.java.model;


import com.m2i.java.ENUM.TypeOperation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Operation {
    @Id
    @Column(nullable=false,updatable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn( name="idCompte" )
    private Compte compte;
    @Column(nullable=false)
    private float montant;
    @Column(nullable=false)
    private LocalDateTime dateOperation;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private TypeOperation typeOperation;


    public Operation(Long id, Compte compte, float montant, LocalDateTime dateOperation, TypeOperation typeOperation) {
        this.id = id;
        this.compte = compte;
        this.montant = montant;
        this.dateOperation = dateOperation;
        this.typeOperation = typeOperation;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Operation{");
        sb.append("id=").append(id);
        sb.append(", compte=").append(compte);
        sb.append(", montant=").append(montant);
        sb.append(", dateOperation=").append(dateOperation);
        sb.append(", typeOperation=").append(typeOperation);
        sb.append('}');
        return sb.toString();
    }
}
