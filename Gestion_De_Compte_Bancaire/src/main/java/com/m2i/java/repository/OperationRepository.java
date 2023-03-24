package com.m2i.java.repository;

import com.m2i.java.model.Compte;
import com.m2i.java.model.Operation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    public List<Operation> findAllByCompteOrderByDateOperationDesc(Compte compte, Pageable pageable);
}
