package com.m2i.java.controller;

import com.m2i.java.DTO.AuthenticateDTO;
import com.m2i.java.DTO.CompteDTO;
import com.m2i.java.DTO.UserDTO;
import com.m2i.java.service.implementation.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


   /* @PostMapping("/authenticate")
    public ResponseEntity<UserDTO> saveCompte(@RequestBody AuthenticateDTO authenticateDTO){
        userService.createUser();
        return ResponseEntity.ok(
                userService.authenticate(authenticateDTO)
        );

    }*/
}
