package com.m2i.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.java.model.Banquier;

public interface BanquierRepository extends JpaRepository<Banquier, Long> {

}
