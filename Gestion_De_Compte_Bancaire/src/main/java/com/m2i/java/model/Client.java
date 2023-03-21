package com.m2i.java.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Data
public class Client extends UserAccount {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false,updatable=false)
    private Long id;

    @Column(unique = true,nullable=false,updatable=false)
    private String numCompte;

    public Client() {
        super();
    }

    @Builder
    public Client(Long id, String numCompte, String login , String password, ROLE role) {
        super(login, password, role);
        this.id = id;
        this.numCompte = numCompte;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Client [id=");
        builder.append(id);
        builder.append(", numCompte=");
        builder.append(numCompte);
        builder.append("]");
        return builder.toString();
    }

}