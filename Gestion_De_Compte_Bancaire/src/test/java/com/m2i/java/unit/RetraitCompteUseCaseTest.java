package com.m2i.java.unit;

import com.m2i.java.DTO.CompteDTO;
import com.m2i.java.DTO.CompteDTOMapper;
import com.m2i.java.inmemory.CompteFakeInMemoryJpaRepository;
import com.m2i.java.model.Agence;
import com.m2i.java.model.Client;
import com.m2i.java.model.Compte;
import com.m2i.java.service.implementation.CompteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class RetraitCompteUseCaseTest {

    private final CompteFakeInMemoryJpaRepository compteRepository = new CompteFakeInMemoryJpaRepository();
    private final CompteDTOMapper compteDTOMapper = new CompteDTOMapper();
    private CompteService compteService;

    private final Agence agence = new Agence();
    private final Client client = new Client();

    private final String numeroCompte = "123456789";


    @BeforeEach
    public void setUp() {
        compteService = new CompteService(compteRepository, null, null, compteDTOMapper);
    }



    @Test
    public void should_not_be_able_to_withdraw(){
        Compte compte = new Compte(1L, numeroCompte, 200.0f, agence, client,1000f, LocalDateTime.now());

        compteRepository.feedWith(compte);

        Assertions.assertThatThrownBy(() -> compteService.retrait(compte.getId(), 10000.0f))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Solde insuffisant");
    }




}
