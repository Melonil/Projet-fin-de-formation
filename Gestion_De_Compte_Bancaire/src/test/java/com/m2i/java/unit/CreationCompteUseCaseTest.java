package com.m2i.java.unit;

import com.m2i.java.DTO.CompteDTOMapper;
import com.m2i.java.inmemory.CompteFakeInMemoryJpaRepository;
import com.m2i.java.service.implementation.CompteService;

public class CreationCompteUseCaseTest {

    private final CompteFakeInMemoryJpaRepository compteRepository = new CompteFakeInMemoryJpaRepository();
    private final CompteDTOMapper compteDTOMapper = new CompteDTOMapper();
    private CompteService compteService;

}
