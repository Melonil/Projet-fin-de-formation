package com.m2i.java.service.implementation;

import com.m2i.java.DTO.AuthenticateDTO;
import com.m2i.java.DTO.UserDTO;
import com.m2i.java.DTO.UserDTOMapper;
import com.m2i.java.ENUM.ROLE;
import com.m2i.java.model.Banquier;
import com.m2i.java.model.Client;
import com.m2i.java.model.UserAccount;
import com.m2i.java.model.UserDetailsClient;
import com.m2i.java.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    private final UserDTOMapper userDTOMapper;

    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }


    public UserDTO authenticate(AuthenticateDTO authenticateDTO) {
        System.out.println(authenticateDTO.getLogin() +" "+ authenticateDTO.getPassword());
        UserAccount useraccount = userRepository.findByLoginAndPassword(authenticateDTO.getLogin(), authenticateDTO.getPassword()).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if(useraccount.getRole().equals(ROLE.BANQUIER)) {
            System.out.println(userDTOMapper.map((Banquier)useraccount));
            return userDTOMapper.map((Banquier)useraccount);
        }else{
            return userDTOMapper.map((Client)useraccount);
        }
    }

   /* public void createUser(){
        UserDetailsClient userDetailsClient = new UserDetailsClient(null,"test","test","test","test","",0D);
        Client user = new Client(null,"test","test","test", ROLE.CLIENT,userDetailsClient);


        userRepository.save(user);
    }*/
}
