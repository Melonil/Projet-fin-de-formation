package com.m2i.java.controller;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.m2i.java.DTO.UserDetailsClientDTO;
import com.m2i.java.model.Response;
import com.m2i.java.service.implementation.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean>	deleteClient(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                clientService.delete(id)
        );

    }
}