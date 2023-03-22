package com.m2i.java.DTO;


import com.m2i.java.model.Banquier;
import com.m2i.java.model.Client;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    public UserDTO map(Client userAccount){
        return new UserDTO(
                userAccount.getId(),
                userAccount.getRole(),
                userAccount.getUserDetailsClient().getNom(),
                userAccount.getUserDetailsClient().getPrenom(),
                userAccount.getUserDetailsClient().getEmail(),
                userAccount.getUserDetailsClient().getNumTel()
        );
    }

    public UserDTO map(Banquier userAccount){
        return new UserDTO(
                userAccount.getId(),
                userAccount.getRole(),
                userAccount.getUserDetails().getNom(),
                userAccount.getUserDetails().getPrenom(),
                userAccount.getUserDetails().getEmail(),
                userAccount.getUserDetails().getNumTel()
        );
    }
}
