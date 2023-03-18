package com.m2i.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.java.model.Compte;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
