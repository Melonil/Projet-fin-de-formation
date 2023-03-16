package com.m2i.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.java.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
