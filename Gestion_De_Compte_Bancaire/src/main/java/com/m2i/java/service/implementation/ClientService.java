package com.m2i.java.service.implementation;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import com.m2i.java.DTO.BanquierDTOMapper;
import com.m2i.java.DTO.UserDetailsClientDTO;
import com.m2i.java.ENUM.ROLE;
import com.m2i.java.model.Banquier;
import com.m2i.java.model.Compte;
import com.m2i.java.model.UserDetailsClient;
import com.m2i.java.repository.BanquierRepository;
import com.m2i.java.repository.ClientRepository;
import com.m2i.java.repository.CompteRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.m2i.java.DTO.UserDetailsClientDTOMapper;
import com.m2i.java.model.Client;
import com.m2i.java.repository.UserDetailsClientRepository;
import com.m2i.java.service.CRUDService;

@Service
public class ClientService implements CRUDService<UserDetailsClientDTO>{
    private final UserDetailsClientRepository userDetailsClientRepository;

    private final ClientRepository clientRepository;

    private final CompteRepository compteRepository;



    private final BanquierRepository banquierRepository;
    private UserDetailsClientDTOMapper userDetailsClientDTOMapper;
    private BanquierDTOMapper banquierDTOMapper;

    public ClientService(UserDetailsClientRepository userDetailsClientRepository, ClientRepository clientRepository, CompteRepository compteRepository, BanquierRepository banquierRepository, UserDetailsClientDTOMapper userDetailsClientDTOMapper) {
        this.userDetailsClientRepository = userDetailsClientRepository;
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
        this.banquierRepository = banquierRepository;
        this.userDetailsClientDTOMapper = userDetailsClientDTOMapper;
    }

    @Override
    public Collection<UserDetailsClientDTO> list(int limit) {
        return clientRepository.findAll(PageRequest.of(0, limit))
                .toList()
                .stream()
                .map(client -> userDetailsClientDTOMapper.map(client,getSoldeClient(client)))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailsClientDTO create(UserDetailsClientDTO userDetailsClientDTO) {

        String login = Math.round(Math.random() * ( 100000000 - 1000000 ))+"";
        String password = Math.round(Math.random() * ( 100000000 - 1000000 ))+"";
        String numClient = Math.round(Math.random() * ( 100000000 - 1000000 ))+"";
        String numCompte = Math.round(Math.random() * ( 100000000 - 1000000 ))+"";


        /*UserDetailsClient userDetailsClient = userDetailsClientRepository.save(userDetailsClientDTOMapper.map(userDetailsClientDTO,null));*/
        Banquier banquier = banquierRepository.findById(userDetailsClientDTO.idBanquier())
                .orElseThrow(() -> new RuntimeException("Banquier non trouvé"));

        Client clientToCreate = new Client(null,numClient,login,password,ROLE.CLIENT, userDetailsClientDTOMapper.map(userDetailsClientDTO,null),banquier,false);



        System.out.println("Saving new Client : " + clientToCreate.getNumClient());
        System.out.println(clientToCreate.toString());
        Client savedClient = clientRepository.save(clientToCreate);

        Compte compte = new Compte(null,numCompte,0,banquier.getAgence(),savedClient,0, LocalDateTime.now());
        compteRepository.save(compte);

        return userDetailsClientDTOMapper.map(savedClient,getSoldeClient(savedClient));
    }

    @Override
    public UserDetailsClientDTO update(UserDetailsClientDTO userDetailsClientDTO) {
        Client client = clientRepository.findById(userDetailsClientDTO.idClient())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        UserDetailsClient userDetailsClient = client.getUserDetailsClient();
        userDetailsClient.setAdressePostale(userDetailsClientDTO.adressePostale());
        userDetailsClient.setRevenu(userDetailsClientDTO.revenu());
        userDetailsClient.setNumTel(userDetailsClientDTO.numTel());
        userDetailsClient.setProfession(userDetailsClientDTO.profession());
        userDetailsClient.setEmail(userDetailsClientDTO.mail());


        System.out.println("Updating Client : " + client.getNumClient());
        userDetailsClientRepository.save(userDetailsClient);

        return userDetailsClientDTOMapper.map(client,getSoldeClient(client));
    }

    @Override
    public UserDetailsClientDTO get(Long id) {
        System.out.println("Retriving  Client by ID : " + id);
        return clientRepository.findById(id).map(client -> userDetailsClientDTOMapper.map(client,getSoldeClient(client))).get();
    }



    public Boolean archive(Long idClient) {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        System.out.println("Deleting Client by ID : " + idClient);
        client.setIsArchived(true);
        clientRepository.save(client);
        return true;
    }
    

    public Collection<UserDetailsClientDTO> listClientsByBanquier(Long id) {
    	Banquier banquier = banquierRepository.findById(id).orElseThrow(() -> new RuntimeException("Banquier non trouvé"));
    	System.out.println("toto");
        return clientRepository.findByBanquierAndIsArchivedFalse(banquier)
                .stream()
                .map(client ->
                        userDetailsClientDTOMapper.map(client,getSoldeClient(client)))
                .collect(Collectors.toList());
    }


    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private float getSoldeClient(Client client){
        Compte compte = compteRepository.findFirstCompteByClientOrderByDateCreation(client);
        return compte.getSolde();
    }

}