package com.m2i.java.DTO;

import com.m2i.java.ENUM.ROLE;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
public class UserDTO {

    private Long id;

    private ROLE role;

    private String nom;

    private String prenom;

    private String email;

    private String numTel;

    public UserDTO(Long id, ROLE role, String nom, String prenom, String email, String numTel) {
        this.id = id;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDTO{");
        sb.append("id=").append(id);
        sb.append(", role=").append(role);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", numTel='").append(numTel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
