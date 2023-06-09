package com.m2i.java.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.m2i.java.DTO.UserDetailsClientDTO;
import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.ClientService;
import com.m2i.java.service.implementation.CompteService;

@RestController
@CrossOrigin
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public ResponseEntity<Collection<UserDetailsClientDTO>> getClients(){
        System.out.println(clientService.list(30));
        return ResponseEntity.ok(
           clientService.list(30)
        );

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDetailsClientDTO> getClient(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                clientService.get(id)
        );

    }

    @PostMapping("/save")
    public ResponseEntity<UserDetailsClientDTO> saveClient(@RequestBody UserDetailsClientDTO userDetailsClientDTO){
        System.out.println(userDetailsClientDTO);
        return ResponseEntity.ok(
             clientService.create(userDetailsClientDTO)
        );

    }

    @PutMapping("/save")
    public ResponseEntity<UserDetailsClientDTO> updateClient(@RequestBody UserDetailsClientDTO userDetailsClientDTO){
        return ResponseEntity.ok(
            clientService.update(userDetailsClientDTO)
        );

    }

    @DeleteMapping("/archive/{id}")
    public ResponseEntity<Boolean>	deleteClient(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                clientService.archive(id)
        );

    }
    
    @GetMapping("/banquier/{idBanquier}")
    public ResponseEntity<Collection<UserDetailsClientDTO>>	getClientsByIdBanquier(@PathVariable("idBanquier") Long id){
        return ResponseEntity.ok(
                clientService.listClientsByBanquier(id)
        );

    }
}