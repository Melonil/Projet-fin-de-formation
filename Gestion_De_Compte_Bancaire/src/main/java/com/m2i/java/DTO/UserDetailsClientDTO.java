package com.m2i.java.DTO;

public record UserDetailsClientDTO(
        Long idClient,
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
        Long idBanquier
) {

}
