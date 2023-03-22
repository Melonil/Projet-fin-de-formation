package com.m2i.java.repository;

import com.m2i.java.model.UserDetailsClient;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.java.model.Client;

public interface UserDetailsClientRepository extends JpaRepository<UserDetailsClient,Long> {

}
