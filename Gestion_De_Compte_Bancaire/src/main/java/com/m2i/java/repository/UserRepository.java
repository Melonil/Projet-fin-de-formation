package com.m2i.java.repository;


import com.m2i.java.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByLoginAndPassword(String username, String password);
}
