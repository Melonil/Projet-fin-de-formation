package com.m2i.java.repository;

import com.m2i.java.model.Banquier;
import com.m2i.java.model.Client;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {


	public Collection<Client> findByBanquierAndIsArchivedFalse(Banquier banquier);



}
