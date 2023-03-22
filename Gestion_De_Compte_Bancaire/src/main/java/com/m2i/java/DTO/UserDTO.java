package com.m2i.java.DTO;

import com.m2i.java.ENUM.ROLE;
import lombok.RequiredArgsConstructor;


public class UserDTO {

    private Long id;

    private ROLE role;

    private String nom;

    private String prenom;

    private String email;

    private String numTel;

    public UserDTO(Long id, ROLE role, String nom, String prenom, String email, String numTel) {
    }
}
