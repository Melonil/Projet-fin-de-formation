
package com.m2i.java.DTO;

import org.springframework.stereotype.Component;

import com.m2i.java.model.Client;
import com.m2i.java.model.UserDetailsClient;
@Component
public class UserDetailsClientDTOMapper {

    public UserDetailsClientDTO map(Client client,float solde) {
        return new UserDetailsClientDTO(
                client.getId(),
                client.getNumClient(),
                client.getUserDetailsClient().getNom(),
                client.getUserDetailsClient().getEmail(),
                client.getUserDetailsClient().getNumTel(),
                client.getUserDetailsClient().getPrenom(),
                client.getUserDetailsClient().getAdressePostale(),
                client.getUserDetailsClient().getDateNaissance(),
                client.getUserDetailsClient().getNationalite(),
                client.getUserDetailsClient().getLieuNaissance(),
                client.getUserDetailsClient().getProfession(),
                client.getUserDetailsClient().getRevenu(),
                solde,
                client.getBanquier().getId()
        );
    }

    public UserDetailsClient map(UserDetailsClientDTO clientDTO,Long id) {
        return new UserDetailsClient(
                id,
                clientDTO.adressePostale(),
                clientDTO.dateNaissance(),
                clientDTO.nationalite(),
                clientDTO.lieuNaissance(),
                clientDTO.profession(),
                clientDTO.revenu(),
                clientDTO.nom(),
                clientDTO.prenom(),
                clientDTO.mail(),
                clientDTO.numTel()
        );
    }
}