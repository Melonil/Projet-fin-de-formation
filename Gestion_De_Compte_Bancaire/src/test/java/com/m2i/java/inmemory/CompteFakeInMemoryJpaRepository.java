package com.m2i.java.inmemory;

import com.m2i.java.model.Client;
import com.m2i.java.model.Compte;
import com.m2i.java.repository.CompteRepository;
import org.springframework.data.domain.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CompteFakeInMemoryJpaRepository implements CompteRepository {

    private final Map<Long, Compte> comptesById = new HashMap<>();

    @Override
    public Compte findByNumeroCompte(String numCompte) {
        return comptesById.values().stream()
                .filter(compte -> compte.getNumCompte().equals(numCompte))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean existsByNumeroCompte(String numeroCompte) {
        return comptesById.values().stream().anyMatch(compte -> compte.getNumCompte().equals(numeroCompte));
    }

    @Override
    public List<Compte> findAll(PageRequest pageRequest) {
        return comptes();
    }

    @Override
    public Compte save(Compte compte) {
        final Compte compteCopy = new Compte(compte);
        compteCopy.setId(comptesById.size() + 1L);
        comptesById.put(compte.getId(), compteCopy);
        return compteCopy;
    }

    @Override
    public Optional<Compte> findById(Long id) {
        return Optional.ofNullable(comptesById.get(id));
    }

    @Override
    public void deleteById(Long id) {
        comptesById.remove(id);
    }

    @Override
    public Compte findFirstCompteByClientOrderByDateCreation(Client client) {
        return null;
    }

    public List<Compte> comptes() {
        return comptesById.values().stream().toList();
    }

    public void feedWith(Compte compte) {
        comptesById.put(compte.getId(), new Compte(compte));
    }
}
