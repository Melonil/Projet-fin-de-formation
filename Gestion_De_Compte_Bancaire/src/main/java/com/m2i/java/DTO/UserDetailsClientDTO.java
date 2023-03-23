package com.m2i.java.DTO;

import java.util.Date;

public record UserDetailsClientDTO(
        Long idClient,

        String numClient,
        String nom,

        String mail,

        String numTel,
        String prenom,
        String adressePostale,
        String dateNaissance,
        String nationalite,
        String lieuNaissance,
        String profession,
        Double revenu,

        float solde,
        Long idBanquier
) {

}
