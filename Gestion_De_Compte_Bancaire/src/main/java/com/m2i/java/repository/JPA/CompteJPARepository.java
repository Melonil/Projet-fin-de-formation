package com.m2i.java.repository.JPA;

import com.m2i.java.model.Client;
import com.m2i.java.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteJPARepository extends JpaRepository<Compte,Long> {
    Compte findFirstCompteByClientOrderByDateCreation(Client client);

    Compte findFirstByClientOrderByDateCreation(Client client);

    Compte findByNumCompte(String numCompte);

    boolean existsByNumCompte(String numeroCompte);
}
