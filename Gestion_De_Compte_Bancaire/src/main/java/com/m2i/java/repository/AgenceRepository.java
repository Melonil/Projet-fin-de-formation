package com.m2i.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.java.model.Agence;

public interface AgenceRepository  extends JpaRepository<Agence,Long> {

}
