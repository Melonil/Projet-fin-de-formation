package com.m2i.java.repository;

import com.m2i.java.model.Client;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.java.model.Compte;

import java.util.List;
import java.util.Optional;

public interface CompteRepository {
    Compte findByNumeroCompte(String numCompte);

    boolean existsByNumeroCompte(String numeroCompte);

    List<Compte> findAll(PageRequest pageRequest);

    Compte save(Compte compte);

    Optional<Compte> findById(Long id);

    void deleteById(Long id);

    Compte findFirstCompteByClientOrderByDateCreation(Client client);
}
