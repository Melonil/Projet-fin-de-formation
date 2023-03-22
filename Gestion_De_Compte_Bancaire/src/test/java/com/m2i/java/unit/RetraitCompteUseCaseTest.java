package com.m2i.java.unit;

import com.m2i.java.DTO.CompteDTOMapper;
import com.m2i.java.inmemory.CompteFakeInMemoryJpaRepository;
import com.m2i.java.model.Agence;
import com.m2i.java.model.Client;
import com.m2i.java.service.implementation.CompteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetraitCompteUseCaseTest {

    private final CompteFakeInMemoryJpaRepository compteRepository = new CompteFakeInMemoryJpaRepository();
    private final CompteDTOMapper compteDTOMapper = new CompteDTOMapper();
    private CompteService compteService;

    private final Agence agence = new Agence();
    private final Client client = new Client();


    @BeforeEach
    public void setUp() {

    }



    @Test
    public void should_not_be_able_to_withdraw(){

    }
}
