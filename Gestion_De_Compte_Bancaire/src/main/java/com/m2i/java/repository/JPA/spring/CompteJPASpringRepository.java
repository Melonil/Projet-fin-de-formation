package com.m2i.java.repository.JPA.spring;

import com.m2i.java.model.Client;
import com.m2i.java.model.Compte;
import com.m2i.java.repository.CompteRepository;
import com.m2i.java.repository.JPA.CompteJPARepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompteJPASpringRepository implements CompteRepository {
    private final CompteJPARepository compteJpaRepository;

    public CompteJPASpringRepository(CompteJPARepository compteJpaRepository) {
        this.compteJpaRepository = compteJpaRepository;
    }

    @Override
    public Compte findByNumeroCompte(String numCompte) {
        return compteJpaRepository.findByNumCompte(numCompte);
    }

    @Override
    public boolean existsByNumeroCompte(String numeroCompte) {
        return compteJpaRepository.existsByNumCompte(numeroCompte);
    }

    @Override
    public List<Compte> findAll(PageRequest pageRequest) {
        return compteJpaRepository.findAll();
    }

    @Override
    public Compte save(Compte compte) {
        return compteJpaRepository.save(compte);
    }

    @Override
    public Optional<Compte> findById(Long id) {
        return compteJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        compteJpaRepository.deleteById(id);
    }

    @Override
    public Compte findFirstCompteByClientOrderByDateCreation(Client client) {
        return compteJpaRepository.findFirstByClientOrderByDateCreation(client);
    }
}
